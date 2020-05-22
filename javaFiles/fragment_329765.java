import java.sql.*;
import java.util.*;
import java.util.concurrent.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchRows {

    private static final Logger log = LoggerFactory.getLogger(FetchRows.class);

    public static void main(String[] args) {

        try {
            new FetchRows().print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void print() throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Properties dbProps = new Properties();
        dbProps.setProperty("user", "test");
        dbProps.setProperty("password", "test");

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", dbProps)) {
            try (Statement st = conn.createStatement()) {
                prepareTestData(st);
            }
            // https://stackoverflow.com/a/2448019/3080094
            try (Statement st = conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY, 
                    java.sql.ResultSet.CONCUR_READ_ONLY)) {
                st.setFetchSize(Integer.MIN_VALUE);
                fetchAndPrintTestData(st);
            }
        }
    }

    boolean refreshTestData = true;
    int maxRecords = 5_555;

    void prepareTestData(Statement st) throws SQLException {

        int recordCount = 0;
        if (refreshTestData) {
            st.execute("drop table if exists fetchrecords");
            st.execute("create table fetchrecords (id mediumint not null auto_increment primary key, created timestamp default current_timestamp)");
            for (int i = 0; i < maxRecords; i++) {
                st.addBatch("insert into fetchrecords () values ()");
                if (i % 500 == 0) {
                    st.executeBatch();
                    log.debug("{} records available.", i);
                }
            }
            st.executeBatch();
            recordCount = maxRecords;
        } else {
            try (ResultSet rs = st.executeQuery("select count(*) from fetchrecords")) {
                rs.next();
                recordCount = rs.getInt(1);
            }
        }
        log.info("{} records available for testing.", recordCount);
    }

    int batchSize = 1_000;
    int maxBatchesInMem = 3;
    int printFinishTimeoutS = 5;

    void fetchAndPrintTestData(Statement st) throws SQLException, InterruptedException {

        final BlockingQueue<List<FetchRecordBean>> printQueue = new LinkedBlockingQueue<List<FetchRecordBean>>(maxBatchesInMem);
        final PrintToConsole printTask = new PrintToConsole(printQueue);
        new Thread(printTask).start();
        try (ResultSet rs = st.executeQuery("select * from fetchrecords")) {
            List<FetchRecordBean> l = new LinkedList<>();
            while (rs.next()) {
                FetchRecordBean bean = new FetchRecordBean();
                bean.setId(rs.getInt("id"));
                bean.setCreated(new java.util.Date(rs.getTimestamp("created").getTime()));
                l.add(bean);
                if (l.size() % batchSize == 0) {
                    /*
                     * The printTask can stop itself when this producer is too slow to put records on the print-queue.
                     * Therefor, also check printTask.isStopping() to break the while-loop.
                     */
                    if (printTask.isStopping()) {
                        throw new TimeoutException("Print task has stopped.");
                    }
                    enqueue(printQueue, l);
                    l = new LinkedList<>();
                }
            }
            if (l.size() > 0) {
                enqueue(printQueue, l);
            }
        } catch (TimeoutException | InterruptedException e) {
            log.error("Unable to finish printing records to console: {}", e.getMessage());
            printTask.stop();
        } finally {
            log.info("Reading records finished.");
            if (!printTask.isStopping()) {
                try {
                    enqueue(printQueue, Collections.<FetchRecordBean> emptyList());
                } catch (Exception e) {
                    log.error("Unable to signal last record to print.", e);
                    printTask.stop();
                }
            }
            if (!printTask.await(printFinishTimeoutS, TimeUnit.SECONDS)) {
                log.error("Print to console task did not finish.");
            }
        }
    }

    int enqueueTimeoutS = 5;
    // To test a slow printer, see also Thread.sleep statement in PrintToConsole.print.
    // int enqueueTimeoutS = 1;

    void enqueue(BlockingQueue<List<FetchRecordBean>> printQueue, List<FetchRecordBean> l) throws InterruptedException, TimeoutException {

        log.debug("Adding {} records to print-queue.", l.size());
        if (!printQueue.offer(l, enqueueTimeoutS, TimeUnit.SECONDS)) {
            throw new TimeoutException("Unable to put print data on queue within " + enqueueTimeoutS + " seconds.");
        }
    }

    int dequeueTimeoutS = 5;

    class PrintToConsole implements Runnable {

        private final BlockingQueue<List<FetchRecordBean>> q;
        private final CountDownLatch finishedLock = new CountDownLatch(1);
        private volatile boolean stop;

        public PrintToConsole(BlockingQueue<List<FetchRecordBean>> q) {
            this.q = q;
        }

        @Override
        public void run() {

            try {
                while (!stop) {
                    List<FetchRecordBean> l = q.poll(dequeueTimeoutS, TimeUnit.SECONDS);
                    if (l == null) {
                        log.error("Unable to get print data from queue within {} seconds.", dequeueTimeoutS);
                        break;
                    }
                    if (l.isEmpty()) {
                        break;
                    }
                    print(l);
                }
                if (stop) {
                    log.error("Printing to console was stopped.");
                }
            } catch (Exception e) {
                log.error("Unable to print records to console.", e);
            } finally {
                if (!stop) {
                    stop = true;
                    log.info("Printing to console finished.");
                }
                finishedLock.countDown();
            }
        }

        void print(List<FetchRecordBean> l) {

            log.info("Got list with {} records from print-queue.", l.size());
            // To test a slow printer, see also enqueueTimeoutS.
            // try { Thread.sleep(1500L); } catch (Exception ignored) {}
        }

        public void stop() {
            stop = true;
        }

        public boolean isStopping() {
            return stop;
        }

        public void await() throws InterruptedException {
            finishedLock.await();
        }

        public boolean await(long timeout, TimeUnit tunit) throws InterruptedException {
            return finishedLock.await(timeout, tunit);
        }

    }

    class FetchRecordBean {

        private int id;
        private java.util.Date created;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public java.util.Date getCreated() {
            return created;
        }
        public void setCreated(java.util.Date created) {
            this.created = created;
        }

    }
}
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Q21176667 implements Runnable {

    private static volatile boolean stop;

    public static void main(String... args) {

        Thread t = new Thread(new Q21176667());
        t.start();
        sleep(200);
        stop = true;
    }

    private BlockingQueue<Long> q = new ArrayBlockingQueue<Long>(100); 

    @Override
    public void run() {

        try {
            while (!stop) {
                if (q.peek() == null) {
                    new Thread(new GetUpdates(this)).start();
                }
                long l = q.take();
                System.out.println("Main sleep: " + l);
                sleep(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Collection<Long> moreData) {

        for (Long l : moreData) {
            q.add(l);
        }
    }

    static class GetUpdates implements Runnable {

        final Q21176667 processor;

        public GetUpdates(Q21176667 processor) {
            this.processor = processor;
        }

        @Override
        public void run() {

            List<Long> vlist = new ArrayList<Long>();
            // Run query, process results
            sleep(10);
            Random r = new Random();
            for (int i = 0; i < 3; i++) {
                vlist.add(new Long(r.nextInt(10)));
            }
            System.out.println("Adding " + vlist.size() + " more sleeps.");
            processor.add(vlist);
        }
    }

    public static void sleep(long timeMs) { 
        try { Thread.sleep(timeMs); } catch (Exception ignored) {}
    }

}
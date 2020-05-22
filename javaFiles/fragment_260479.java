import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RunEngine {
    public static void main(String[] args) throws Exception {
        final String rpt = "/tmp/rpt/input/rpt-1.rpt";
        final String sFilePath = "/tmp/rpt/output/";
        final String sFileName = "pdfreport";
        final Object[] data = new Object[10];

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for (int i = 0; i < data.length; i++) {
            PDFExporterRunnable runnable = new PDFExporterRunnable(rpt, data[i], sFilePath, sFileName, i);
            executor.execute(runnable);
        }
        executor.shutdown();
        executor.awaitTermination(1L, TimeUnit.HOURS);
        Engine.stopAll();
        Engine.shutdown();
    }
    private static class PDFExporterRunnable implements Runnable {
        private final String rpt;
        private final Object data;
        private final String sFilePath;
        private final String sFileName;
        private final int runIndex;


        public PDFExporterRunnable(String rpt, Object data, String sFilePath,
                String sFileName, int runIndex) {
            this.rpt = rpt;
            this.data = data;
            this.sFilePath = sFilePath;
            this.sFileName = sFileName;
            this.runIndex = runIndex;
        }

        @Override
        public void run() {
            // Loops
            Engine eng = new Engine(Engine.EXPORT_PDF);
            eng.setReportFile(rpt); // rpt is the report name
            Connection cn = null;

            /*
             * DB connection related code. Check and use.
             */
            //if (cn.isClosed() || cn == null) {
                //cn = ds.getConnection();
            //}
            eng.setConnection(cn);
            System.out.println(" After set connection");

            eng.setPrompt(data, 0);
            ReportProperties repprop = eng.getReportProperties();
            repprop.setPaperOrient(ReportProperties.DEFAULT_PAPER_ORIENTATION,
                    ReportProperties.PAPER_FANFOLD_US);
            eng.execute();
            System.out.println(" After excecute");
            FileOutputStream fos = null;
            try {
                String FileName = sFileName + "_" + runIndex;
                File file = new File(sFilePath + FileName + ".pdf");
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                fos = new FileOutputStream(file);
                for (int k = 1; k <= eng.getPageCount(); k++) {
                    fos.write(eng.getPageData(k));
                }
                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fos = null;
                }
            }
        }
    }
    /*
     * Dummy classes to avoid compilation errors.
     */
    private static class ReportProperties {
        public static final String PAPER_FANFOLD_US = null;
        public static final String DEFAULT_PAPER_ORIENTATION = null;
        public void setPaperOrient(String defaultPaperOrientation, String paperFanfoldUs) {
        }
    }

    private static class Engine {
        public static final int EXPORT_PDF = 1;
        public Engine(int exportType) {
        }
        public static void shutdown() {
        }
        public static void stopAll() {
        }
        public void setPrompt(Object singleData, int i) {
        }
        public byte[] getPageData(int k) {
            return null;
        }
        public int getPageCount() {
            return 0;
        }
        public void execute() {
        }
        public ReportProperties getReportProperties() {
            return null;
        }
        public void setConnection(Connection cn) {
        }
        public void setReportFile(String reportFile) {
        }
    }
}
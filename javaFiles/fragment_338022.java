public class FileWatcherTest {

    public static void main(String args[]) {
        (new Thread(new FileWatcherRunnable("first.log"))).start();
        (new Thread(new FileWatcherRunnable("second.log"))).start();
    }

    private static class FileWatcherRunnable implements Runnable {
        private String logFilePath;
        // you should inject the file path of the log file to watch
        public FileWatcherRunnable(String logFilePath) {
           this.logFilePath = logFilePath;
        }
        public void run() {
            // your code from main goes in here
        }
    }
}
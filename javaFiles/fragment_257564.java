public class Logger {
    private final Object LOCK = new Object();

    public void log(String s) {
        synchronized (LOCK) {
           //write to log
        }
    }

    public void log(int i) {
        synchronized (LOCK) {
           //write to log
        }
    }
 }
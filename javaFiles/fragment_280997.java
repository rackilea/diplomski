Thread thread = new Thread(new Ticker());
thread.setDaemon(true); // Otherwise the JVM won't stop when you want it t
thread.start();

//...

public class Ticker implements Runnable {
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exp) {
            }
            // Update static reference to the clock...
        }
    }
}
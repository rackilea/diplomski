public class MyThread extends Thread {
    private final long interval;
    private final String message;
    public MyThread(long interval, String message) {
        this.interval = interval;
        this.message = message;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(message);
            try {
                sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
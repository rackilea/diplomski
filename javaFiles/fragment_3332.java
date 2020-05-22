class BackgroundThread extends Thread {
    public volatile int value = 0, i = 0;

    @Override
    public synchronized void run() {
        while (i < 2) {
            value++;
            i++;
            notify();
            try {
                System.out.println("background thread wait start");
                wait();
                System.out.println("background thread notified");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int getValue() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}

public class ThreadTest {
    public static int value1, times = 0;

    public static void main(String[] args) {
        BackgroundThread backgroundThread = new BackgroundThread();
        backgroundThread.start();

        while (times < 3) {
            synchronized (backgroundThread) {
                value1 = backgroundThread.getValue();
                times++;
                System.out.println(value1);
                System.out.println(backgroundThread.getState());
                backgroundThread.notify();
                try {
                    backgroundThread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
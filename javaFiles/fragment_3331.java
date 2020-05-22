class Foo implements Runnable {
    public volatile int value = 0, i = 0;
    private Thread backgroundThread;

    public void setThread(Thread thread) {
        this.backgroundThread = thread;
    }

    @Override
    public void run() {
        synchronized (backgroundThread) {
            while (i < 2) {
                value++;
                i++;
                backgroundThread.notify();
                try {
                    System.out.println("background thread wait start");
                    backgroundThread.wait();
                    System.out.println("background thread notified");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
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
        Foo foo = new Foo();
        final Thread thread = new Thread(foo);
        foo.setThread(thread);
        thread.start();

        while (times < 3) {
            synchronized (thread) {
                value1 = foo.getValue();
                times++;
                System.out.println(value1);
                System.out.println(thread.getState());
                thread.notify();
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
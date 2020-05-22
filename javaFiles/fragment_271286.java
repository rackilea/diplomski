public class Tester {

    public static final Object LOCK = new Object();

    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        synchronized (LOCK) {
            try {
                System.out.println("wating for t to complete");
                LOCK.wait();
                System.out.println("wait over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyRunnable implements Runnable {

        public void run() {
            System.out.println("entering run method");
            synchronized (LOCK) {
                System.out.println("entering syncronised block");
                LOCK.notify();
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("leaving syncronized block");
            }
            System.out.println("leaving run method");
        }
    }
}
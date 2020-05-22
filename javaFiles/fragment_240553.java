public class TwoThread {

    public static void main(String[] args) throws InterruptedException {
        ThreadA a1 = new ThreadA();
        Thread t1 = new Thread(a1);

        synchronized (a1) {
            t1.start();
            for (int i = 0; i < 5; i++) {
                a1.wait();
                System.out.println("perform some action " + i);
                a1.notify();
            }

        }
    }
}

public class ThreadA implements Runnable {
    boolean suspended = false;
    boolean stopped = false;

    void job() throws InterruptedException {
        for (int i = 0; i < 5; i++)
            synchronized (this) {
                System.out.println("performing job. " + i);
                notify();
                wait();
            }
    }

    public void run() {
        try {
            job();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
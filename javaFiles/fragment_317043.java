private static boolean running = true;

public void test26546397() {

    while (true) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        running = true;
        // Do recovery
    }
}


public class MyRunnable implements Runnable {

    @Override
    public void run() {
        while (running) {
            try {
                // doStuff
            } catch (Exception ex) {
                running = false;
            }
        }
    }
}
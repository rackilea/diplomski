public class JoinExample implements Runnable {

    public static final void main(String[] args) {
        Thread t = new Thread(new JoinExample());

        System.out.println("Starting thread");
        t.start();

        if (args.length > 0) {
            System.out.println("Joining thread");
            while (t.isAlive()) {
                try {
                    t.join();
                }
                catch (InterruptedException ie) {
                }
            }
        }

        System.out.println("main exiting");
    }

    public void run() {
        long    stop = System.currentTimeMillis() + 2000;

        System.out.println("Thread starting");
        while (System.currentTimeMillis() < stop) {
            // Sleep a mo
            try {
                Thread.currentThread().sleep(250);
            }
            catch (InterruptedException ie) {
            }
            System.out.println("Thread still running");
        }
        System.out.println("Thread stopping");
    }
}
public class Test extends Thread {

    static volatile boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {
        final Thread t = new Test();
        t.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutting down...");
                keepRunning = false;
                t.interrupt();
                try {
                    t.join();
                } catch (InterruptedException e) {
                }
            }
        });
    }

    public void run() {
        while (keepRunning) {
            System.out.println("worknig...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }

        System.out.println("cleaning up.");
    }
}
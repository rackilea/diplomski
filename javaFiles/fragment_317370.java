public class App {

    private static final AtomicBoolean done = new AtomicBoolean(false);

    private static final class First implements Runnable {

        @Override
        public void run() {
            while (!done.get()) {
                System.out.println("Waiting.");
                synchronized (done) {
                    try {
                        done.wait();
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
            }
            System.out.println("Done!");
        }
    }

    private static final class Second implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
            done.set(true);
            synchronized (done) {
                done.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new First());
        Thread.sleep(1000);
        executorService.submit(new Second());
        executorService.shutdown();

    }
}
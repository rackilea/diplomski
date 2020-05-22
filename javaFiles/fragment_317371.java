public class App {

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    private static final class First implements Runnable {

        @Override
        public void run() {
            lock.lock();
            System.out.println("Waiting");
            try {
                condition.await();
            } catch (InterruptedException ex) {
                return;
            } finally {
                lock.unlock();
            }
            System.out.println("Done!");
        }
    }

    private static final class Second implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                Thread.sleep(1000);
                condition.signalAll();
            } catch (InterruptedException ex) {
                return;
            } finally {
                lock.unlock();
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
public static void main(String[] args) {
    AtomicInteger counter = new AtomicInteger(Decrementer.MAX_SIZE);
    ReadWriteLock lock = new ReentrantReadWriteLock();

    for (int i = 1; i <= 10; i++) {
        Decrementer d = new Decrementer(counter, lock);
        new Thread(d).start();
    }
}

static public class Decrementer implements Runnable {

    public final static int MAX_SIZE = 5;
    private ReadWriteLock lock;
    private AtomicInteger counter;

    public Decrementer(AtomicInteger counter, ReadWriteLock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    public void run() {
        while (true) {
            try {
                lock.writeLock().lock();
                int current = this.counter.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + " at counter " + current);
                if (current <= 0) {
                    this.counter.set(Decrementer.MAX_SIZE);
                    System.out.println(Thread.currentThread().getName() + " reset " + current + " to " + Decrementer.MAX_SIZE);
                    Thread.sleep(4217);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
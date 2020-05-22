public class Warehouse {
    private static final AtomicInteger numberProvider = new AtomicInteger(0);
    private final int number;
    private final Lock lock = new ReentrantLock();
    // ...
    public Warehouse(...) {
        this.number = numberProvider.incrementAndGet();
        ...
    }
    // ... (getter for number and lock and other methods)
}
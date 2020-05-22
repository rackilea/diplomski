public class AutocloseableExecutorService implements ExecutorService, AutoCloseable {
    private ExecutorService delegate;
    public AutocloseableExecutorService(ExecutorService d) {
        delegate = d;
    }
    // delegate ExecutorService methods to implement the interface
    public void execute(Runnable r) { delegate.execute(r); 
    // ...

    // implement close() for AutoCloseable
    public void close() {
        delegate.shutdown();
    }
}
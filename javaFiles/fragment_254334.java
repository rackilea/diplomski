public class TransactionalFlushingWorker extends TransactionalWorker {

private static final int INDEX_BATCH_SIZE = 2000;

private final AtomicInteger indexingWithoutFlushCounter = new AtomicInteger();

public void performWork(Work<?> work, TransactionContext transactionContext) {
    super.performWork(work, transactionContext);
    if (indexingWithoutFlushCounter.incrementAndGet() > INDEX_BATCH_SIZE) {
        flushWorks(transactionContext);
    }
}

public void flushWorks(TransactionContext transactionContext) {
    indexingWithoutFlushCounter.set(0);
    super.flushWorks(transactionContext);
}
}
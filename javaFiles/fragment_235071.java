public class MyTransactionManager implements TransactionManager {

private final TransactionManager originalManager = ...;

public <V> V ensureTransaction(Callable<V> transaction, HGTransactionConfig config) {
    // Check for appropriate type
    if( transaction instanceof Handable) {
        for (HGPersistentHandle ph: ((Handable) transaction).getHandles()) {
            writeJedis.watch(ph.toByteArray);
        }
    }
    // Delegate to the original implementation
    return originalManager.ensureTransaction(transaction, config);
}
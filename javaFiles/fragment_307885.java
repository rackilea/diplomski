/**
 * Execute some arbitrary operation(s) on the operations and return the result.
 * The operations are invoked within a local transaction and do not participate
 * in a global transaction (if present).
 * @param callback the callback.
 * @param <T> the result type.
 * @return the result.
 * @since 1.1
 */
<T> T executeInTransaction(OperationsCallback<K, V, T> callback);
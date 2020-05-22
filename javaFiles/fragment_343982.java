/**
 * Specify the {@link TransactionSynchronizationFactory} to attach a
 * {@link org.springframework.transaction.support.TransactionSynchronization}
 * to the transaction around {@code poll} operation.
 * @param transactionSynchronizationFactory the TransactionSynchronizationFactory to use.
 * @return the spec.
 */
public PollerSpec transactionSynchronizationFactory(
        TransactionSynchronizationFactory transactionSynchronizationFactory) {
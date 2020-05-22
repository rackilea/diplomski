class MandatoryTransactionSpringManagedTransactionFactory extends SpringManagedTransactionFactory {
     public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
         if (!TransactionSynchronizationManager.isActualTransactionActive()) {
              throw new IllegalTransactionStateException(
                "No existing transaction found during mapper invocation");
         }
         return super.newTransaction(dataSource);
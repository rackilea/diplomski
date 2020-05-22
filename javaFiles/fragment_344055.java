public class AutoCommitTransactionDatabaseLookup extends DefaultDatabaseOperationLookup {

    @Override
    public org.dbunit.operation.DatabaseOperation get(DatabaseOperation operation) {
        if (operation == operation.CLEAN_INSERT) {
            return AutoCommitTransactionOperation.AUTO_COMMIT_TRANSACTION(org.dbunit.operation.DatabaseOperation.CLEAN_INSERT);
        }
        return super.get(operation);
    }
}
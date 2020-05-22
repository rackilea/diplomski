public class AutoCommitTransactionOperation extends DatabaseOperation {

    private final DatabaseOperation _operation;

    public AutoCommitTransactionOperation(DatabaseOperation operation) {
        _operation = operation;
    }

    public static final DatabaseOperation AUTO_COMMIT_TRANSACTION(DatabaseOperation operation) {
        return new AutoCommitTransactionOperation(operation);
    }

    public void execute(IDatabaseConnection connection, IDataSet dataSet) throws DatabaseUnitException, SQLException {
        logger.debug("execute(connection={}, dataSet={}) - start", connection, dataSet);

        IDatabaseConnection databaseConnection = connection;
        Connection jdbcConnection = databaseConnection.getConnection();

        boolean autoCommit = jdbcConnection.getAutoCommit();
        jdbcConnection.setAutoCommit(false);
        try {
            _operation.execute(databaseConnection, dataSet);
            jdbcConnection.commit();
        } catch (DatabaseUnitException e) {
            jdbcConnection.rollback();
            throw e;
        } catch (SQLException e) {
            jdbcConnection.rollback();
            throw e;
        } catch (RuntimeException e) {
            jdbcConnection.rollback();
            throw e;
        } finally {
            jdbcConnection.setAutoCommit(autoCommit);
        }
    }
}
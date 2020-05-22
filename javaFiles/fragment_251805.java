protected void createTempTable(Queryable persister, SessionImplementor session) {
    // Don't really know all the codes required to adequately decipher returned jdbc exceptions here.
    // simply allow the failure to be eaten and the subsequent insert-selects/deletes should fail
    TemporaryTableCreationWork work = new TemporaryTableCreationWork( persister );
    if ( shouldIsolateTemporaryTableDDL( session ) ) {
        session.getTransactionCoordinator()
                .getTransaction()
                .createIsolationDelegate()
                .delegateWork( work, shouldTransactIsolatedTemporaryTableDDL( session ) );
    }
    else {
        final Connection connection = session.getTransactionCoordinator()
                .getJdbcCoordinator()
                .getLogicalConnection()
                .getConnection();
        work.execute( connection );
        session.getTransactionCoordinator()
                .getJdbcCoordinator()
                .afterStatementExecution();
    }
}
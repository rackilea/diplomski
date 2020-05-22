protected void releaseTempTable(Queryable persister, SessionImplementor session) {
    if ( session.getFactory().getDialect().dropTemporaryTableAfterUse() ) {
        TemporaryTableDropWork work = new TemporaryTableDropWork( persister, session );
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
    else {
        // at the very least cleanup the data :)
        PreparedStatement ps = null;
        try {
            final String sql = "delete from " + persister.getTemporaryIdTableName();
            ps = session.getTransactionCoordinator().getJdbcCoordinator().getStatementPreparer().prepareStatement( sql, false );
            session.getTransactionCoordinator().getJdbcCoordinator().getResultSetReturn().executeUpdate( ps );
        }
        catch( Throwable t ) {
            log.unableToCleanupTemporaryIdTable(t);
        }
        finally {
            if ( ps != null ) {
                try {
                    session.getTransactionCoordinator().getJdbcCoordinator().release( ps );
                }
                catch( Throwable ignore ) {
                    // ignore
                }
            }
        }
    }
}
try {
    session = getSessionFactory().openSession();
    txn = session.beginTransaction();
    session.doWork(new Work() {
        @Override
        public void execute(Connection connection) throws SQLException {
            LOGGER.debug("Transaction isolation level is {}", Environment.isolationLevelToString(connection.getTransactionIsolation()));
        }
    });
    txn.commit();
} catch (RuntimeException e) {
    if ( txn != null && txn.isActive() ) txn.rollback();
    throw e;
} finally {
    if (session != null) {
        session.close();
    }
}
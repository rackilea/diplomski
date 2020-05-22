private Customer getCustomer(final DataSourceTransactionManager txMan,
                             final JdbcTemplate t,
                             final String id) {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);

    TransactionStatus status = txMan.getTransaction(def);
    Customer c = null;
    try {
        c = t.queryForObject(SELECT_CUSTOMER, new CustomerRowMapper(), id);
    } catch (Exception ex) {
        txMan.rollback(status);
        throw ex;
    }
    txMan.commit(status);
    return c;
}
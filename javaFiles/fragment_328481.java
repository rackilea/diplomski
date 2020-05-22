@Autowired
@Bean(name = "transactionManager")
public PlatformTransactionManager transactionManager(PlatformTransactionManager db1TransactionManager, PlatformTransactionManager db2TransactionManager)
        throws Exception {
    return new ChainedTransactionManager(db1TransactionManager,
           db2TransactionManager);
}
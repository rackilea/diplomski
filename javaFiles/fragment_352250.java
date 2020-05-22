@Bean
public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
    final FooTransactionManager transactionManager = new FooTransactionManager();
    transactionManager.setEntityManagerFactory(emf);

    transactionManager.configureTxTimeout(Foo.class, "doStuff", 10);
    transactionManager.configureTxTimeout(Bar.class, "doStuff", 20);
    transactionManager.configureTxTimeout(Bar.class, "doMoreStuff", 30);
    //blablabla

    return transactionManager;
}
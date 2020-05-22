@Bean
@Autowired
public HibernateTransactionManager transactionManager(
    SessionFactory sessionFactory) {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(sessionFactory());
    return txManager;
}
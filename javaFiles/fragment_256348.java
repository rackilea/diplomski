@Bean @Qualifier("primary_tx")

    public HibernateTransactionManager getPrimaryTransactionManager() throws IOException {
        HibernateTransactionManager txName= new HibernateTransactionManager();
        txName.setSessionFactory(sessionFactory().getObject());
        return txName;
    }
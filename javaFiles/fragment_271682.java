private static SessionFactory sessionFactory;
private static ServiceRegistry serviceRegistry;

private static SessionFactory configureSessionFactory() throws HibernateException {
    Configuration configuration = new Configuration();
    configuration.configure();

    serviceRegistry = new ServiceRegistryBuilder()
             .applySettings(configuration.getProperties())
             .buildServiceRegistry();

    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    return sessionFactory;
}
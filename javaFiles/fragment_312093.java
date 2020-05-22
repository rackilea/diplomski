Configuration configuration = new Configuration().configure();
ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
registry.applySettings(configuration.getProperties());
ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

Session session = sessionFactory.openSession();
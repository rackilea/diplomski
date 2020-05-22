private static SessionFactory buildSessionFactory() {
        try {


            Configuration configuration = new Configuration();
            configuration.configure();
            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
            standardServiceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.configure().build();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch(Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
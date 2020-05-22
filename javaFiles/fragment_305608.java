private static SessionFactory buildSessionFactory()
{
    try
    {
        // Create session factory from cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                                                .configure("hibernate.cfg.xml")
                                                .build();


        Metadata Meta = new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(User.class)
                        .addAnnotatedClassName("de.fani.cooking.model.User")
                        .getMetadataBuilder()
                        .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                        .build();

        SessionFactory sessionFactory = Meta.getSessionFactoryBuilder()
                                        .build();

        return sessionFactory;
    }
    catch (Throwable ex)
    {
        System.err.println("Initial session factory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}
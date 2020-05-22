static {
    try {
        // Create the SessionFactory from app.properties

        Properties properties = new Properties();
        properties.load(new FileInputStream("src//main//resources//app.properties"));
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addProperties(properties);
        sessionFactory = configuration.buildSessionFactory();

    } catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
        LOG.info("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}
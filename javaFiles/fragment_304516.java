private static final SessionFactory sessionFactory;

static {
    try {
        // Create the SessionFactory from standard (hibernate.cfg.xml) 
        // config file.


        Properties c = new Properties();
        c.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        c.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        c.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydiscou_billing?zeroDateTimeBehavior=convertToNull");
        c.setProperty("hibernate.connection.username", "root");
        c.setProperty("hibernate.connection.password", "123");
        c.setProperty("hibernate.connection.autoReconnect", "true");

        c.setProperty("connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
        c.setProperty("c3p0.min_size", "5");
        c.setProperty("c3p0.max_size", "20");
        c.setProperty("c3p0.timeout", "1800");
        c.setProperty("c3p0.max_statements", "100");
        c.setProperty("hibernate.c3p0.testConnectionOnCheckout", "true");




        sessionFactory = new AnnotationConfiguration().setProperties(c).configure().buildSessionFactory();
    } catch (Throwable ex) {
        // Log the exception. 
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}

public static SessionFactory getSessionFactory() {
    return sessionFactory;
}
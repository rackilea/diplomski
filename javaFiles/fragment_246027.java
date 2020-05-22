private static SessionFactory buildSessionFactory() {
  try {
    Configuration config = new Configuration();
    config = config.configure("resources/hibernate.cfg.xml");
    config.setProperty("hibernate.connection.url", properties.getProperty("dburl"));            
    SessionFactory session = config.buildSessionFactory();
    return session;
  }
  catch (Throwable ex) {
    System.err.println("Initial SessionFactory creation failed." + ex);
    throw new ExceptionInInitializerError(ex);
  }
}
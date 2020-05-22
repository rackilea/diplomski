public static void SetSessionFactory(String url, String user, String pass) {
    try {

      AnnotationConfiguration conf = new AnnotationConfiguration().configure();
      // <!-- Database connection settings -->
      conf.setProperty("hibernate.connection.url", url);
      conf.setProperty("hibernate.connection.username", user);
      conf.setProperty("hibernate.connection.password", pass);
      sessionFactory = conf.buildSessionFactory();

    } catch (Throwable ex) {
      // Log exception!
      throw new ExceptionInInitializerError(ex);
    }
  }
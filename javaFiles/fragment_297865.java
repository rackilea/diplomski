private static final SessionFactory sessionFactory;

private static synchronized SessionFactory getSessionFactory() {
     if (sessionFactory == null) {
          sessionFactory = new Configuration().configure().buildSessionFactory();
     }
     return sessionFactory;
}
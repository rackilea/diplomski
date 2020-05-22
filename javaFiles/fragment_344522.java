private static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
        sessionFactory = createSessionFactory();
    }
    return sessionFactory;
}
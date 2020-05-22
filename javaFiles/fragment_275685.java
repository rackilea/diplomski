try {
    sessionFactory = ...getSessionFactory(className);
    session = sessionFactory.openSession();
}
catch (Exception e) {
    e.printStackTrace();
}
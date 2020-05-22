public static SessionFactory changeConfiguration(String login, String password){
    Configuration cfg = new Configuration();
    cfg.configure();
    cfg.setProperty("hibernate.connection.password", password);
    cfg.setProperty("hibernate.connection.username", login); 
    SessionFactory sessionFactory = cfg.buildSessionFactory();
    return sessionFactory;
}
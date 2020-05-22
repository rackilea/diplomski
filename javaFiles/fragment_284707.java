public static void configureHibernateUtil(String user, String pass) {
    try {
        Configuration cfg = new Configuration();
        cfg.configure("/dao/hibernate.cfg.xml"); //hibernate config xml file name
        //String newUserName = null, newPassword = null;//set them as per your needs
        cfg.getProperties().setProperty("hibernate.connection.password", pass);
        cfg.getProperties().setProperty("hibernate.connection.username", user);
        //In next line you just tell Hibernate which classes are you going to query

        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(ssrb.build());
    } catch (HibernateException he) {
        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
        throw new ExceptionInInitializerError(he);
    }
}
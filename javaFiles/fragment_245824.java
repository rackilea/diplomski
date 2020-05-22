public static void setConnectionProperties() {
    URL configFileURL = null;

    try {
        configFileURL = URL_OF_YOUR_CFG_XML_FILE;
        configuration = (new Configuration()).configure(configFileURL);
        sessionFactory = configuration.buildSessionFactory();

    } catch (HibernateException e) {
        e.printStackTrace(); 
        System.out.println("Error while initializing hibernate: " + e.getMessage());
    }

}
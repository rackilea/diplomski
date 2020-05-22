SessionFactory getSessionFactory(className) {
    try {
         configuration.addResource( className + ".hbm.xml" );
    }catch (Exception e) {
    e.printStackTrace();
}

configuration.configure();
serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
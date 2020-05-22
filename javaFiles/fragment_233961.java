Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml"); //hibernate config xml file name
String newUserName,newPassword;//set them as per your needs
cfg.getProperties().setProperty("hibernate.connection.password",newPassword);
cfg.getProperties().setProperty("hibernate.connection.username",newUserName);
sessionFactory = cfg.buildSessionFactory();
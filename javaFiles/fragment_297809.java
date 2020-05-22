java.util.Properties properties = new Properties();
properties.load(new FileInputStream("db.properties"));

Configuration configuration = new Configuration();

configuration.configure("hibernate.cfg.xml").addProperties(properties);;

ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
.applySettings(configuration.getProperties()).build();

SessionFactory sessionFactory = configuration
.buildSessionFactory(serviceRegistry);
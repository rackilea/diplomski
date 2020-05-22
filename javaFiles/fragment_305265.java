URL file = ConsultaBase.class.getProtectionDomain().getCodeSource().getLocation()
    .toURI().resolve("hibernate.cfg.xml").toURL(); 

Configuration configuration = new Configuration()
    .addAnnotatedClass(Registro.class).configure(file);         

ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    .applySettings(configuration.getProperties())
    .build();

Thread.currentThread().setContextClassLoader(Registro.class.getClassLoader());

sessionFactory = configuration.buildSessionFactory(serviceRegistry);
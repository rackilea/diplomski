@Before
public void before() {    
    Configuration configuration = new Configuration();
    configuration = configuration.configure();

    StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
    registryBuilder = registryBuilder.applySettings(configuration.getProperties());

    StandardServiceRegistry registry = registryBuilder.build();
    sessionFactory = configuration.buildSessionFactory(registry);
    session = sessionFactory.openSession();
}
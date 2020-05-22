File config = new File("./config/hibernate.cfg.xml");   
StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    .configure(config) 
    .build();
try 
{
    sessionFactory = new MetadataSources(registry)
        .buildMetadata().buildSessionFactory();
}
catch (Exception e) {
    e.printStackTrace();
    StandardServiceRegistryBuilder.destroy( registry );
    throw e;
}
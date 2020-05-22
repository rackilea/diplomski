// sessionFactory bean will be available
@Bean
public SessionFactory getSessionFactory(DataSource dataSource) {

    LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

    builder.addProperties(getHibernateProperties());
    builder.scanPackages("net.kzn.shoppingbackend.dto");

    return builder.buildSessionFactory();
}
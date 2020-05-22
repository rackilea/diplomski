@Bean(name = "sessionFactory")
public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean localSession = new LocalSessionFactoryBean();
    localSession.setDataSource(dataSource());

    localSession.setMappingResources("my.hmb.xml", "files.hbm.xml");

    return localSession;
}
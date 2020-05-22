@Bean(name = DEMO_DS)
public JndiObjectFactoryBean demoDataSource() {
    JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
    factory.setJndiName(JDBC_DEMO_DS);
    factory.setProxyInterface(DataSource.class);
    return factory;
}

@Bean(name = DEMO_SESSION_FACTORY)
public SqlSessionFactoryBean demoSqlSessionFactory() {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(demoDataSource().getObject());
    sessionFactory.setConfigLocation(new ClassPathResource("demo/config.xml"));
    return sessionFactory;
}
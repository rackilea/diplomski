@Bean(name = DEMO_SESSION_FACTORY)
public SqlSessionFactoryBean demoSqlSessionFactory() {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(demoDs);
    sessionFactory.setConfigLocation(new ClassPathResource("demo/config.xml"));
    return sessionFactory;
}
@Bean
public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    // ....
    sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
    // ....
    return sessionFactory;
}
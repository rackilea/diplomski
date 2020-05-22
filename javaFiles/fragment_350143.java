@Bean
public LocalSessionFactoryBean  sessionFactory(DataSource ds) throws ClassNotFoundException {
    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    localSessionFactoryBean.setDataSource(dataSource());
    ... // Other settings here
    return localSessionFactoryBean;
}
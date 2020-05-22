@Bean
public LocalSessionFactoryBean sessionFactory() {
   LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
   sessionFactory.setDataSource(restDataSource());
   sessionFactory.setPackagesToScan(
       new String[] { "base.package.to.scan" }
   );
   sessionFactory.setHibernateProperties(hibernateProperties());

   return sessionFactory;
}

@Bean
public DataSource restDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("drivr");
    dataSource.setUrl("url"));
    dataSource.setUsername("uname");
    dataSource.setPassword("passwd");
    return dataSource;
}

Properties hibernateProperties() {
    return new Properties() {
        {
            setProperty("hibernate.hbm2ddl.auto", create);
            setProperty("hibernate.dialect", dielect_to_use);
        }
    };
}
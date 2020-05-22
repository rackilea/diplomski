@Bean(name="DB1SessionFactory")
public LocalSessionFactoryBean db1SessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(new String[] { "org.npcc.ccms.model.db1" });
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
 }

@Bean
public SessionFactory sessionFactory() {
    return db1SessionFactory().getObject();
}
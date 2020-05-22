@Bean
public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
    lsfb.setDataSource(this.dataSource());
    lsfb.setPackagesToScan(new String[] { 
        "operaciones.telefonoscvts.dao"
    });
    lsfb.setHibernateProperties(this.hibernateProperties());
    return sessionFactory;
}
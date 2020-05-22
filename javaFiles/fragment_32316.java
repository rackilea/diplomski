@Bean
public DataSource dataSource(){
    // configure your datasource
}

@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    emfb.setDataSource(dataSource);
    emfb.setPackagesToScan("your.package.with.model"); 
    emfb.setJpaVendorAdapter(jpaVendorAdapter());
    emfb.setJpaPropertyMap(jpaPropertiesMap()); 
    return emfb;
}

@Bean 
public JpaVendorAdapter jpaVendorAdapter() {
    return new HibernateJpaVendorAdapter();
}

@Bean
public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
}

public Map<String, ?> jpaPropertiesMap() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); // assumption based on your pom-file
    properties.setProperty("hibernate.hbm2ddl.auto", "..."); // you need to google for appropriate option
    return properties;
}
@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
    hibernateJpaVendorAdapter.setShowSql(true);
    localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
    return localContainerEntityManagerFactoryBean;
}

@Bean
BasicDataSource basicDataSource() {
    BasicDataSource basicDataSource = new BasicDataSource();

    basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
    basicDataSource.setUrl("jdbc:mysql://localhost:3306/dirtylibs");
    basicDataSource.setUsername("root");
    basicDataSource.setPassword("password");

    return basicDataSource;
}


@Bean
JpaTransactionManager jpaTransactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());
    return jpaTransactionManager;
}
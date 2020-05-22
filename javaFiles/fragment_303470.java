@Bean(name = "postgresqlEntityManager")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(postgresqlDataSource());
        factoryBean.setJpaPropertyMap(hibernateProperties());
        factoryBean.setPackagesToScan("com.server.entity.postgresql");
        factoryBean.setPersistenceUnitName("postgresqlPU");

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL95Dialect");

        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        return factoryBean;
    }
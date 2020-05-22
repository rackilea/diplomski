@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan("foo.bar.web.domain");
        factory.setDataSource(dataSource());
        factory.setJpaPropertyMap(new HashMap<String, Object>() {{
            put("hibernate.dialect", dialect);
            put("hibernate.hbm2ddl.auto", hbm2ddl);
        }});
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
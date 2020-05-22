@Bean
public DataSource dataSource() {
    EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
    return embeddedDatabaseBuilder.addScript("classpath:org/springframework/batch/core/schema-drop-h2.sql")
            .addScript("classpath:org/springframework/batch/core/schema-h2.sql")
            .setType(EmbeddedDatabaseType.H2)
            .build();
}

@Bean
public ResourcelessTransactionManager transactionManager() {
    return new ResourcelessTransactionManager();
}

@Bean
public JobRepository jobRepository() throws Exception {
    JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
    factory.setDatabaseType(DatabaseType.H2.getProductName());
    factory.setDataSource(dataSource());
    factory.setTransactionManager(transactionManager());
    return factory.getObject();
}
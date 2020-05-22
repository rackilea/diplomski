@Bean
public MapJobRepositoryFactoryBean mapJobRepositoryFactory(
        ResourcelessTransactionManager txManager) throws Exception {
    MapJobRepositoryFactoryBean factory = new
            MapJobRepositoryFactoryBean(txManager);
    factory.afterPropertiesSet();
    return factory;
}
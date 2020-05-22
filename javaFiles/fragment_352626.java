@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager",
        basePackages = {"com.server.second.repo"}
)
public class SecondDBConfiguration  

@Bean("secondDatasource")
@ConfigurationProperties(prefix="spring.secondDatasource")
public DataSource secondaryDataSource() {
return DataSourceBuilder.create().build();
}

@Bean(name = "secondEntityManagerFactory")
public LocalContainerEntityManagerFactoryBean
secondEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("secondDatasource") DataSource dataSource
) {
    return
            builder
                    .dataSource(dataSource)
                    .packages("com.server.shadow.domain")
                    .persistenceUnit("shadow")
                    .build();
}
@Bean(name = "secondTransactionManager")
public PlatformTransactionManager secondTransactionManager(
        @Qualifier("secondEntityManagerFactory") EntityManagerFactory
                secondEntityManagerFactory
) {
    return new JpaTransactionManager(secondEntityManagerFactory);
}
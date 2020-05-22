@Configuration
public class ActivitiConfiguration extends AbstractProcessEngineAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "datasource.activiti")
    public DataSource activitiDataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:h2:mem:activiti")
                .username("activiti")
                .driverClassName("org.h2.Driver")
                .build();
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            PlatformTransactionManager transactionManager,
            SpringAsyncExecutor springAsyncExecutor) throws IOException {

        return baseSpringProcessEngineConfiguration(
                activitiDataSource(),
                transactionManager,
                springAsyncExecutor);
    }
}
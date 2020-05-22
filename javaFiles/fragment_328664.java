@Configuration
@EnableConfigurationProperties(DataSourcesConfiguration.class)
public class DatabaseConnectionConfiguration implements Provider<Connection> {

    private DataSourcesConfiguration dataSourcesConfiguration;

    public DatabaseConnectionConfiguration(DataSourcesConfiguration dataSourcesConfiguration) {
        this.dataSourcesConfiguration = dataSourcesConfiguration;
    }

    @Bean
    public DataSource dataSource() {
        // Use dataSourcesConfiguration to create application data source. E.g., a AbstractRoutingDataSource..
    }

}
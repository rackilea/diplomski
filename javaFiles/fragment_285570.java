@Bean
@Primary
@ConfigurationProperties(prefix = "spring.datasource")
public DataSource dataSource() {

    // provision your Google Cloud SQL database instance here

    return DataSourceBuilder.create().build();
}
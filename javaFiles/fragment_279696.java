@Primary
@Bean(name = "dataSource")
@ConfigurationProperties(prefix="spring.datasource")
public DataSource dataSource() {
    return DataSourceBuilder.create().build();
}
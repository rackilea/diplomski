@Bean
@Primary
@ConfigurationProperties(prefix = "datasource.primary")
public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
}

@Bean(name = "secondaryDatasource")
@ConfigurationProperties(prefix = "datasource.secondary")
public DataSource secondaryDataSource() {
    return DataSourceBuilder.create().build();
}
@Bean
@ConfigurationProperties(prefix="txn")
public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
}

@Bean
@ConfigurationProperties(prefix="rpt")
public DataSource secondaryDataSource() {
    return DataSourceBuilder.create().build();
}
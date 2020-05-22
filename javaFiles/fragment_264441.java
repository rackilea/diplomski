@ConfigurationProperties(prefix = DataSourceAutoConfiguration.CONFIGURATION_PREFIX)
@Bean
public DataSource dataSource() {
    DataSourceBuilder factory = DataSourceBuilder
            .create(this.properties.getClassLoader())
            .driverClassName(this.properties.getDriverClassName())
            .url(this.properties.getUrl())
            .username(this.properties.getUsername())
            .password(this.properties.getPassword());
    return factory.build();
}
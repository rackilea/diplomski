@Primary
@Bean
public DataSource customDataSource() {

    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("custom.datasource.driver-class-name"));
    dataSource.setUrl(env.getProperty("custom.datasource.url"));
    dataSource.setUsername(env.getProperty("custom.datasource.username"));
    dataSource.setPassword(env.getProperty("custom.datasource.password"));

    return dataSource;

}
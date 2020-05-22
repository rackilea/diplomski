@Bean
public DataSource dataSource(){
    DriverManagerDataSource source = new DriverManagerDataSource();
    source.setDriverClassName(driverClass);
    source.setUrl(url);
    source.setUsername(username);
    source.setPassword(password);
    return source;
}
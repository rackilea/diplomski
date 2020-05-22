@Value("${jdbc.driverClassName}")
private String driverClassName;

@Value("${jdbc.url}")
private String url;

@Value("${jdbc.user}")
private String username;

@Value("${jdbc.pass}")
private String password;

@Bean
public DataSource restDataSource(){
    final BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
}

@Bean
public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholder() {
    return new PropertySourcesPlaceholderConfigurer();
}
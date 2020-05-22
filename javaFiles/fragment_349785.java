@Bean
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:port/DB_NAME");
    dataSource.setUsername("root");
    dataSource.setPassword("");
    return dataSource;
}
@Bean
public DataSource hsqlDataSource(){
    return DataSourceBuilder
        .create()
        .driverClassName("org.hsql.jdbcDriver")
        .url("jdbc:hsqldb:file:src/test/resources/testData;shutdown=true;")
        .username("SA")
        .password("");
        .build();
}
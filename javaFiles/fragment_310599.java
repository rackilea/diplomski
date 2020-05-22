@Bean
public DataSource dataSource(){
    String driverClassName = messageSource().getMessage(...);
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(driverClassName); // I want to set the parameter as given message stored by messageSource

    return dataSource;
}
@Bean
JdbcTemplate jdbcTemplate() throws IllegalAccessException, InvocationTargetException, InstantiationException {
    // extract this 4 parameters using your own logic
    final String driverClassName = "org.h2.Driver";
    final String jdbcUrl = "jdbc:h2:mem:test";
    final String username = "sa";
    final String password = "";
    // Build dataSource manually:
    final Class<?> driverClass = ClassUtils.resolveClassName(driverClassName, this.getClass().getClassLoader());
    final Driver driver = (Driver) ClassUtils.getConstructorIfAvailable(driverClass).newInstance();
    final DataSource dataSource = new SimpleDriverDataSource(driver, jdbcUrl, username, password);
    // or using DataSourceBuilder:
    final DataSource dataSource = DataSourceBuilder.create().driverClassName(driverClassName).url(jdbcUrl).username(username).password(password).build();
    // and make the jdbcTemplate
    return new JdbcTemplate(dataSource);
}
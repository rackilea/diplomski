@Bean
public DataSource dataSource() {
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(Play.application().configuration().getString("db.default.driver"));
    dataSource.setUrl(Play.application().configuration().getString("db.default.url"));
    dataSource.setUsername(Play.application().configuration().getString("db.default.user"));
    dataSource.setPassword(Play.application().configuration().getString("db.default.password"));
    return dataSource;
}
public DataSource getDataSource(String user, String password) {
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.url(DBB_URL);
    dataSourceBuilder.username(user);
    dataSourceBuilder.password(password);
    return dataSourceBuilder.build();   
}
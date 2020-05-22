@Bean(destroyMethod = "")
public DataSource dataSource() {
    final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
    dsLookup.setResourceRef(true);
    return dsLookup.getDataSource("jdbc/xdrstoredbds");
}
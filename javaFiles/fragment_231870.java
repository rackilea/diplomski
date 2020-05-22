@Override
public void execute(Database database) throws CustomChangeException {
    JdbcConnection connection = (JdbcConnection) database.getConnection();
    DataSource dataSource = new SingleConnectionDataSource(connection.getUnderlyingConnection(), true);
    JdbcTemplate template = new JdbcTemplate(dataSource, false);
}
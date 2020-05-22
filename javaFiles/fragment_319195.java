protected static Connection getConnection() throws NamingException, SQLException {
    InitialContext cxt = new InitialContext();
    String jndiName = "java:/comp/env/jdbc/MyDBHrd";
    DataSource dataSource = (DataSource) cxt.lookup(jndiName);
    Connection conn = dataSource.getConnection();
    return conn;
}
public Connection createConnection() throws NamingException, SQLException {
    // Setup the Database datasource
    Context ctx = new InitialContext();
    Context env = (Context) ctx.lookup("java:comp/env");
    DataSource ds = (DataSource) env.lookup("jdbc/carRentalSystem");
    return ds.getConnection();
}
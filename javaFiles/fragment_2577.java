private <T> T query(Connection conn, boolean closeConn, String sql, 
                     ResultSetHandler<T> rsh, Object... params)
...
PreparedStatement stmt = null;
ResultSet rs = null;
T result = null;

try {
    stmt = this.prepareStatement(conn, sql);
    this.fillStatement(stmt, params);
    rs = this.wrap(stmt.executeQuery());
    result = rsh.handle(rs);
} catch (SQLException e) {
...
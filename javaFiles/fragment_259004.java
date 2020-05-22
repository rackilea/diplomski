class CustomQueryRunner extends AbstractQueryRunner {

    private final RowHandler rh;

    CustomQueryRunner(DataSource ds, StatementConfiguration stmtConfig, RowHandler rh) {
        super(ds, stmtConfig);
        this.rh = rh;
    }

    int query(String sql) throws SQLException {
        Connection conn = this.prepareConnection();
        return this.query(conn, true, sql);
    }

    private int query(Connection conn, boolean closeConn, String sql, Object... params)
            throws SQLException {
        if (conn == null) {
            throw new SQLException("Null connection");
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            stmt = this.prepareStatement(conn, sql);
            this.fillStatement(stmt, params);
            rs = this.wrap(stmt.executeQuery());
            count = rh.handle(rs);
        } catch (SQLException e) {
            this.rethrow(e, sql, params);
        } finally {
            try {
                close(rs);
            } finally {
                close(stmt);
                if (closeConn) {
                    close(conn);
                }
            }
        }
        return count;
    }
}
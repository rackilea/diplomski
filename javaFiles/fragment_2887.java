public static boolean executeQuery(String query) {
    try {
        Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
        throw new DbException("Could not find JDBC driver", e);
    }

    Connection conn = null;
    Statement stmt = null;

    try {
        conn = DriverManager.getConnection(Global.dbPath);
        stmt = conn.createStatement();
        stmt.execute(query);
        return true;
    } catch(SQLException e) {
        throw new DbException("Exception during statement execution", e);
    } finally {
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(stmt);
    }
}
public ResultSet getAll(String location, String profile) throws SQLException {
    Connection conn = ds.getConnection();
    try {
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM JOBPROFILE WHERE LOCATION='"+location+"' AND JOBFUNCTION='"profile"'");
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(result);
        return crs;
    } finally {
        conn.close();
    }
}
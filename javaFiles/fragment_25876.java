public int insertValues(String profession, String features) {
    String sql = "INSERT INTO test values(?, ?)";
    Connection conn;
    PreparedStatement ps;
    try {
        conn = dbcon.connectDB();

        ps = conn.prepareStatement(sql);
        ps.setString(1, profession);
        ps.setString(2, features);
        return ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE,
                null, ex);
    } finally {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception ignored) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
    }
    return 0;
}
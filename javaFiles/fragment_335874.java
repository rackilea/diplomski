Connection conn = null;
PreparedStatement ps = null;
ResultSet rs = null;

try {
    // Do stuff
    ...

} catch (SQLException ex) {
    // Exception handling stuff
    ...
} finally {
    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) { /* ignored */}
    }
    if (ps != null) {
        try {
            ps.close();
        } catch (SQLException e) { /* ignored */}
    }
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) { /* ignored */}
    }
}
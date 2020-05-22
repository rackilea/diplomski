PreparedStatement pstmt = null;
ResultSet r = null;
try {
    pstmt = conn.prepareStatement(firstsql);
    r = pstmt.executeQuery();
    // do something with the ResultSet
} finally {
    if (r != null) {
        try {
            r.close();
        } catch (SQLException e) {
            //log error
        }
    }
    if (pstmt != null) {
        try {
            pstmt.close();
        } catch (SQLException e) {
            //log error
        }
    }
}
//and do it again
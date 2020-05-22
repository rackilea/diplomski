Statement stmt=null;
ResultSet rs=null;
try {
    try {
        final Statement stmt = con.createStatement();
        final String sql = "select 1 from dual";
        rs = stmt.executeQuery(sql);
        while(rs.next()) {
            // do something with the data
        }
        rs.close();
        rs=null;
        stmt.close();
        stmt=null;
    } catch (final Exception e) {
        throw new RuntimeException("SQL failure");
    }
} finally {
    if (rs!=null) {
        try {
            rs.close();
        } catch (Exception e) {
            // ignore - we can't do too much
        }
    }
    if (stmt!=null) {
        try {
            stmt.close();
        } catch (Exception e) {
            // ignore - we can't do too much
        }
    }
}
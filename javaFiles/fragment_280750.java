Connection con;
try {
   con = ...; // open connection
   // do work
catch (SQLException e) {
   // do whatever
} finally {
    if (con != null && !con.isClosed()) {
        try {
            con.close();
        catch (SQLException e) {
            // Don't throw from here or you'll lose any return/exception from above
            log.error("Failed to close connection", e);
        }
    }
}
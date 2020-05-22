public static boolean tableExists(String tableName, Connection con) {
    try (Statement stmt = con.createStatement();
         ResultSet trs = stmt.executeQuery(
             String.format(
                 "SELECT count(*) from (SELECT 1 FROM %s WHERE ROWNUM = 1) T", 
                 tableName
             )
         )
    ) {
        return trs.next();
    }
    catch (SQLException e) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("SQLException occurs while checking the table " + tableName, e);
        }
        return false;
    }
}
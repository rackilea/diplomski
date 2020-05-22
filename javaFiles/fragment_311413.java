public static Boolean recordsExist(String string, Connection c) {
    try {
        String[] query = string.split("\\*");
        String sql = "select count(*) as total" + query[1];
        Statement s = c.createStatement();
        ResultSet resultset = queryDB(sql, c, s);
        resultset.next();
        int count = resultset.getInt(1);
        Log.debug(Integer.toString(count));
        resultset.close();
        s.close();
        if (count > 0) {
            Log.debug("recordsExist returning true");
            return true;
        } else {
            Log.debug("recordsExist returning false");
            return false;
        }

    } catch (Exception e) {
        Log.debug(e.getMessage());
        return false;
    }
}

public static ResultSet queryDB(String sql, Connection c, Statement s ) throws SQLException {
    Log.debug(sql);
    ResultSet resultset = s.executeQuery(sql);
    return resultset;
}
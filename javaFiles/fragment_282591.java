private String loadRawData(String id) throws SQLException
{
    Connection con = getSourceConnection();
    Statement stmt = null;
    String query = "select data from table where id='" + id + "'";

    String rawData = null;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            rawData = rs.getString("data");
        }
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    return rawData;
}
public static ArrayList getTablesMetadata() throws SQLException {
    String table[] = { "TABLE" };
    ResultSet rs = null;
    ArrayList tables = null;
    // receive the Type of the object in a String array.
    rs = metadata.getTables(null, null, null, table);
    tables = new ArrayList();
    while (rs.next()) {
        tables.add(rs.getString("TABLE_NAME"));
    }
    return tables;
}
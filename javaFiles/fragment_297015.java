public String[] getColumnContents(String tableName, String columnName) {
String sql = "SELECT " + columnName + " FROM " + tableName + " ORDER BY " + columnName1 + " ASC, " + columnName2 + " ASC";

String[] results = new String[SQLManager.getColumnLength(tableName, columnName)];

try {
    rs = statement.executeQuery(sql);

    for (int counter = 0; rs.next(); counter++) {
        results[counter] = rs.getString(columnName);
    }
} catch (SQLException e) {
    e.printStackTrace();
}

return results;

}
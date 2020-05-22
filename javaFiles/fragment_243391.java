public int countColumnsInTable(String sectionType) {
    int count = 16;
    try {
        Statement statement = connection.createStatement();
        ResultSet rset = statement.executeQuery("SELECT * FROM " + sectionType);
        ResultSetMetaData rsMetaData = rset.getMetaData();
        count = rsMetaData.getColumnCount();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    // Remember to clean up
    return count;
}
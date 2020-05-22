public static void createNewTable(String databaseName, String tableName, List<String[]> columns) {
    // SQLite connection string
    String url = "jdbc:sqlite:" + databaseName;
    String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
    StringBuilder sql = new StringBuilder(query);

    String prefix = "";

    for (String[] s : columns) {
        sql.append(prefix);
        prefix = ", ";
        sql.append(s[0]);
        sql.append(" ");
        sql.append(s[1]);
    }

    sql.append(");");
    System.out.println(sql);

    try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
        // create a new table
        stmt.execute(sql.toString());
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public static void main(String[] args) {
    List<String[]> list = new ArrayList<>();
    list.add(new String[]{"col1", "type1"});
    list.add(new String[]{"col2", "type2"});
    list.add(new String[]{"col3", "type3"});
    list.add(new String[]{"col4", "type4"});
    list.add(new String[]{"col5", "type5"});
    createNewTable("database_name", "table_name", list);
}
public String columnsLike(String like, String... cols) {
    return columnsLike(like, Arrays.asList(cols));
}

public String columnsLike(String like, List<String> cols) {
    List<String> where = new ArrayList<>();
    for(String column : cols) {
        where.add(column+" LIKE '"+like+"'");
    }
    return where.stream().collect(Collectors.joining(" OR "));
}

public List<String> getColumns(String table) {
    ResultSet rs = statement.executeQuery("SELECT * FROM "+table);
    ResultSetMetaData rsmd = rs.getMetaData();
    List<String> columns = new ArrayList<String>();
    for (int i = 1; i < rsmd.getColumnCount(); ++i) { columns.add(rsmd.getColumnName(i)); }
    return columns;
}

String query = "SELECT * FROM table_name WHERE "+columnsLike('%'+textField.getText()+'%', "column1", "column2", "column3", "column4", "column5");
// Result:
// SELECT * FROM table_name WHERE column1 LIKE '%hello%' OR column2 LIKE '%hello%' OR column3 LIKE '%hello%' OR column4 LIKE '%hello%' OR column5 LIKE '%hello%'

// However you could save time from writing out every column and load them once into an array. 
List<String> columns = getColumns("table_name");
// Then call columnsLike('%'+textField.getText()+'%', columns);
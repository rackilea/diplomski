Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM Clients WHERE ID <= 2");

// collect column names
List<String> columnNames = new ArrayList<>();
ResultSetMetaData rsmd = rs.getMetaData();
for (int i = 1; i <= rsmd.getColumnCount(); i++) {
    columnNames.add(rsmd.getColumnLabel(i));
}

int rowIndex = 0;
while (rs.next()) {
    rowIndex++;
    // collect row data as objects in a List
    List<Object> rowData = new ArrayList<>();
    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        rowData.add(rs.getObject(i));
    }
    // for test purposes, dump contents to check our results
    // (the real code would pass the "rowData" List to some other routine)
    System.out.printf("Row %d%n", rowIndex);
    for (int colIndex = 0; colIndex < rsmd.getColumnCount(); colIndex++) {
        String objType = "null";
        String objString = "";
        Object columnObject = rowData.get(colIndex);
        if (columnObject != null) {
            objString = columnObject.toString() + " ";
            objType = columnObject.getClass().getName();
        }
        System.out.printf("  %s: %s(%s)%n",
                columnNames.get(colIndex), objString, objType);
    }
}
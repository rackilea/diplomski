ResultSetMetaData rsmd = rs.getMetaData();
int columnCount = rsmd.getColumnCount();

// A HashMap with column names as key
Map<String, List<String>> columns = new HashMap<>(columnCount);

// Loop through columns, rename as you wish
for (int i = 1; i <= columnCount; i++) {
    if (rsmd.getColumnLabel(i).equals("NAME")) {
        if (rsmd.getTableName(i).equals("TYPE_LEAVES")) {
            columns.put("L_NAME", new ArrayList<>());
        } else {
            columns.put("APP_NAME", new ArrayList<>());
        }
    } else {
        columns.put(rsmd.getColumnLabel(i), new ArrayList<>());
    }
}

// Iterate over ResultSet rows, add values to columns
while (rs.next()) {
    for (int i = 1; i <= columnCount; i++) {
        String columnName = rsmd.getColumnLabel(i);
        String tableName = rsmd.getTableName(i);
        if (columnName.equals("NAME")) {
            if (tableName.equals("TYPE_LEAVES")) {
                columns.get("L_NAME").add(rs.getString(i));
            } else {
                columns.get("APP_NAME").add(rs.getString(i));
            }
        } else {
            columns.get(columnName).add(rs.getString(i))
        }
    }
}

// Print, for example, first row values for L_NAME and APP_NAME columns
System.out.println(columns.get("L_NAME").get(0));
System.out.println(columns.get("APP_NAME").get(0));

// Prints:
// leave type 1
// application type 1
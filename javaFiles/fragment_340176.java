DatabaseMetaData meta = connection.getMetaData();
ResultSet rs = meta.getColumns(null, null, tableName, null);

while (rs.next()){
    System.out.println(rs.getString("COLUMN_NAME"));
}
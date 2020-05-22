DatabaseMetaData metadata = connection.getMetaData();
ResultSet resultSet = metadata.getColumns(null, null, "mytable", null);  // table name is mytable
while (resultSet.next()) {
  String name = resultSet.getString("COLUMN_NAME");
  String type = resultSet.getString("TYPE_NAME");
  int size = resultSet.getInt("COLUMN_SIZE");
}
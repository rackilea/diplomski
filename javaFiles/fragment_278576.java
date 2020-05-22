ResultSet rs;
rs = stat.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES");

List ll = new LinkedList();

// Fetch each row from the result set
while (rs.next()) {
  String tableName = rs.getString("TABLE_NAME");

  ll.add(tableName);
}
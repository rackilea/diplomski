DatabaseMetaData dbm = con.getMetaData();
ResultSet tables = dbm.getTables(null, null, "your_table_name", null);
if (tables.next()) {
  // Table exists
}
else {
  // Table does not exist
}
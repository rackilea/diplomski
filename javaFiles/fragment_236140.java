DatabaseMetaData md = conn.getMetaData();
ResultSet rs = md.getTables(null, null, "table_name", null);
if (!rs.next()) {
  //Table not Exist, let's create it 
}
//Insert data into the table ...
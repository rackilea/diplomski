DatabaseMetaData md = connection.getMetaData();
ResultSet rs = dbmd.getColumns(null, null, tableName, "%"); 
while(rs.next()) { 
    String column = rs.getString("COLUMN_NAME"); 
    System.out.println(column); 
}
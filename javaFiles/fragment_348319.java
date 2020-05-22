Connection c = ...
Statement stmt = c.createStatement();
String sql = "SELECT * FROM test WHERE Column_X IN ('";
for(int i=0; i < list.size(); i++) {
   if(i > 0) {
      sql += ",'"
   }
   sql += list.get(i) + "'";
}
sql += ")";
ResultSet r = stmt.executeQuery(sql);
String excelQuery = "select * from [Sheet$]1";
String excelQuery2 = "select * from [Sheet$]2";
rs = stmt.executeQuery(excelQuery);

while (rs.next()) {
  System.out.println(rs.getString("name") + " " + rs.getString("age"));
}
rs = stmt.executeQuery(excelQuery2);
while (rs.next()) {
  System.out.println(rs.getString("name") + " " + rs.getString("age"));
}
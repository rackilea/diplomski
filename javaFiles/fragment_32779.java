PreparedStatement stmt (possible assignment here);
try
{
 // do all work with prepared statement
 ResultSet rs;
 try
 {
   while (rs.next()) ...
   // process results
 }
 finally
 {
   rs.close();
 }
}
finally
{
  stmt.close();
}
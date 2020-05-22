ResultSet rs=stmt.executeQuery(sql);
try{
  rs.next();                // move to the first row
  return rs.getBoolean(1);  // first column is 1
}
finally{
  rs.close();
}
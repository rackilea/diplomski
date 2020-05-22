String originalSql = sql_string + " ";
String append = " "; 
while(res.next()) {
   sql_string += append + res.getString(1);            
   append = " union " + originalSql;
}
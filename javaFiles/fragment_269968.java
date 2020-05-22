String date= "2016/11/01"
String queryString "exec sp_dmp_pub_status ?";
PreparedStatement ps = conn.prepareStatement(queryString);         
SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
Date parsed = format.parse(date);
java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
ps.setDate(1, sqlDate);        
ResultSet rs = ps.executeQuery();
String sql = "select s_upload_file.NEXTVAL from dual" ;
 PreparedStatement ps = con.prepareStatement(sql);
 ResultSet rs = ps.executeQuery();
 if (rs.next())
 {
   int var2= rs.getInt(1);
 }
PreparedStatement pst = null;
String sql = "SELECT id, userId, password FROM login where username=? and password=?";
pst = con.prepareStatement(sql);
pst.setString(1,user);
pst.setString(2,pass);
ResultSet rs = pst.executeQuery();
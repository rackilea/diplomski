String sql="UPDATE tbGroup SET GPassword=? where GName=? and OEmail=?";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, myPassword);
ps.setString(2, groupName);
ps.setString(3, ownerId);
ps.executeUpdate();
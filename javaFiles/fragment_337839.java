String username = "..."; //the username, it could be a method parameter
String password = "..."; //the password, it could be a method parameter
Connection con = .... //retrieve the connection the way you're doing it now
//replace ... for the data you want/need from user
String sql = "SELECT ... FROM user WHERE name = ? and password = ?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, username);
pstmt.setString(2, password);
ResultSet rs = pstmt.executeQuery();
if (rs.next()) {
    //read the data from ResultSet
}
rs.close();
pstmt.close();
con.close();
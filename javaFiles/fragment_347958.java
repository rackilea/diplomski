//other codes here
String iSQL = "Insert into books(title, author, description, prize) values (?,?,?,?)";
// con is your active connection object
PreparedStatement pstmt = con.prepareStatement(iSQL);
pstmt.setString(1, title);
pstmt.setString(2, author);
pstmt.setString(3, desc);
pstmt.setFloat(4, prize);
pstmt.executeUpdate();
//other codes here
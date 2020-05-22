Connection con = DriverManager.getConnection(connectStr, username, password);
//from "SELECT id, name, category FROM ingredient WHERE id=" + intId
//check the usage of ? instead of intId
String sql = "SELECT id, name, category FROM ingredient WHERE id = ?";
PreparedStatement pstmt = con.prepareStatement(sql);
//setting variable in PreparedStatement
pstmt.setInt(1, intId);
ResultSet rs = pstmt.executeQuery();
String result = "";
while (rs.next()) {
    //consume the data...
}
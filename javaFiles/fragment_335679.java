Connection con = DriverManager.getConnection(connectStr, username, password);
//? don't need you to escape it by using ' around
//? is equals to the parameter, this is why using PreparedStatement is more safe
//it will help you to avoid SQL Injection attacks
String sql = "SELECT id, name, category FROM ingredient WHERE name = ?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, theName);
ResultSet rs = pstmt.executeQuery();
String result = "";
while (rs.next()) {
    //consume the data...
}
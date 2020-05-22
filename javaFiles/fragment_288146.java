// as you are using preparedStatement you can use ? and then set value for it to prevent sql injection
String sql = "Select * from placeseen where ID = ?";
DatabaseConnection db = new DatabaseConnection();
Connection conn = db.getConnection();
PreparedStatement ps = conn.prepareStatement(sql);
ps.setDouble(1, aa[i]);  // 1 represent first attribute represented by ?

System.out.println(ps); // this will print query in console

ResultSet rs = ps.executeQuery();
if (rs.next()) {
    System.out.println("Inside rs.next()");  // for debug purpose
    String aaa;
    aaa=rs.getString("place1");
    System.out.println(aaa);
}
// remaining code
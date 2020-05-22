PreparedStatement pstmt = con.prepareStatement("select insert_order(?,?)");
pstmt.setString(1, "foo");
pstmt.setInt(2, 42);

rs = pstmt.executeQuery();

if (rs.next()) {
  System.out.println("Generated ID is: " + rs.getInt(1));
}
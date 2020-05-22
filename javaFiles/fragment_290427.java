PreparedStatement pstmt = con.prepareStatement("select * from doquery(?)");
pstmt.setInt(1, 33434);

ResultSet results = pstmt.executeQuery();
while (results.next()) {
  // do something with the results...
}
results.close();
proc.close();
String sql = "SELECT * FROM " + TABLE_NAME + " WHERE docName = ?";
PreparedStatement preparedStatement = conn.prepareStatement(sql);
preparedStatement.setString(1, myInput);
ResultSet rs = preparedStatement.executeQuery();
while (rs.next()) {
  // iterate through results
}
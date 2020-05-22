try {
  String em = EmailField.getText();
  String na = NameField.getText();
  String su = SurnameField.getText();
  String i = IDField.getText();
  String ce = CellField.getText();

  String query2 = "UPDATE LouwDataBase.Table1Test "
                 + "SET Email = ?, "
                 + "Name = ?, "
                 + "Surname = ?, "
                 + "ID = ?, "
                 + "Cell = ?"
                 + " WHERE Email = ?";

  conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDataBase", "LouwDataBase", "1234");
  stat = conn.createStatement();

  try (Connection conn = this.connect();
  PreparedStatement pstmt = conn.prepareStatement(query2)) {
      pstmt.setString(1, em);
      pstmt.setString(3, na);
      pstmt.setString(4, su);
      pstmt.setString(5, i);
      pstmt.setString(6, ce);
      pstmt.executeUpdate();
   } 
   catch (SQLException e) {
      System.out.println(e.getMessage());
   } 
}
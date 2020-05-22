int enter = Integer.parseInt(txtEnter.getText());
String sql = "SELECT userid" +
              " FROM video" +
             " GROUP BY userid" +
            " HAVING COUNT(video_name) = ?";
try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase", "root", "pass1234");
     PreparedStatement stmt = con.prepareStatement(sql)) {
    stmt.setInt(1, enter);
    try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            // handle row
            String userid = rs.getString("userid");
            model.addRow(new Object[]{i});
            table.setModel(model);
        }
    }
}
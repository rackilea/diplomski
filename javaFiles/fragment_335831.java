String query = "SELECT COUNT(email) AS mailc, email from users where users.email =?";
PreparedStatement preparedStmt = conn.prepareStatement(query);
preparedStmt.setString(1, mail);

ResultSet result = preparedStmt.executeQuery();
while (result.next()) {
   int count = result.getInt("mailc");
   String email = result.getString("email");
}
String sql = "INSERT INTO users(email, password, login, familiya, name, otchestvo, age, country, city, mob, skype) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

 try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
     preparedStatement.setString(1, user.getEmail);
     preparedStatement.setString(2, user.getPassword);
     preparedStatement.setString(3, user.getLogin());
     preparedStatement.setString(4, user.getFamiliya());
     preparedStatement.setString(5, user.getName());
     preparedStatement.setString(6, user.getOtchestvo());
     preparedStatement.setInt(7, 11);
     preparedStatement.setString(8, user.getCountry());
     preparedStatement.setString(9, user.getCity());
     preparedStatement.setString(10, user.getMob());
     preparedStatement.setString(11, user.getSkype());
     preparedStatement.executeUpdate();
}
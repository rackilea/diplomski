Connection connection = MyResource.getConnection();
query = "UPDATE users SET password = ? WHERE mail = ?";

stmt = connection.prepareStatement(query);
stmt.setString(1,jsonObject.getString("password"));
stmt.setString(2,jsonObject.getString("mail"));
stmt.executeUpdate();
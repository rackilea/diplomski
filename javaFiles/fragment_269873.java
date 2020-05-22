String sql = "Insert into Employee (id, name, full_time) values (?, ?, ?)";
PreparedStatement s = connection.prepareStatement(sql);
s.setString(1, "100");
s.setString(2, "John");
s.setBoolean(3, true);
s.executeUpdate();
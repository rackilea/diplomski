PreparedStatement stmt = conn.prepareStatement("SELECT * FROM member WHERE member_username = ? AND member_password = ?");
stmt.setString(1, username);
stmt.setString(2, password);
stmt.execute();

ResultSet rs = stmt.getResultSet();
// ...
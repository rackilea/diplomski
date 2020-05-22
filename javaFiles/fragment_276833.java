String query = "update access set email=? where username=?";
PreparedStatement ps = con.prepareStatement(query);

ps.setString(1, email);
ps.setString(2, name);
ps.executeUpdate();
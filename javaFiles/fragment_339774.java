PreparedStatement ps = (PreparedStatement) conn.prepareStatement("UPDATE user_table set first_name=?,last_name=?,email=? WHERE userTableID = ?");
                ps.setString(1, newFirstName);
                ps.setString(2, newLastName);
                ps.setString(3, newEmail);
                ps.setString(4, userId);
                ps.executeUpdate();
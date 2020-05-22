String sql = "INSERT INTO users (uuid, authKey, code, scratches) VALUES (?, ?, ?, ?)";
PreparedStatement insertStmt = connection.prepareStatement(sql);
insertStmt.setString(1, uuid);
insertStmt.setString(2, key);
insertStmt.setInt(3, code);
insertStmt.setString(4, getScratchString());
insertStmt.executeUpdate();      
connection.commit();
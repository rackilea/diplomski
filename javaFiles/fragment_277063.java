sql = "INSERT INTO clientdata (client_id, weight, height, birthday) VALUES (?, ?, ?, ?)";
PreparedStatement pstmt = connection.prepareStatement(sql);
pstmt.setInteger(1, client.getID());
pstmt.setInteger(2, client.getWeight());
pstmt.setInteger(3, client.getHeight());
pstmt.setTimestamp(4, new java.sql.Timestamp(client.getBirthday().getTime()));
pstmt.executeUpdate();
pstmt.close();
PreparedStatement stmt = conn.prepareStatement("insert into Players values(?,?,?,?,?,?)");
stmt.setInt (1, Integer.parseInt(temp[0]));
stmt.setString (2, temp[1]);
stmt.setString (3, temp[2]); 
stmt.setString (4, temp[3]); 
stmt.setString (5, temp[4]);
stmt.setInt (6, Integer.parseInt(temp[5]));
stmt.executeUpdate();
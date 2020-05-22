String sql = "UPDATE Page SET Title = ? WHERE Name = ?";

PreparedStatement stmt = connection.prepareStatement(sql);

stmt.setString( 1, "update" );
stmt.setString( 2, "Name3" );
stmt.executeUpdate();
stmt.close();
PreparedStatement statement = null;
String sql = "UPDATE table SET val=? WHERE 1";

statement = con.prepareStatement(sql);
statement.setString(1, jsonString);
statement.executeUpdate();
con.commit();
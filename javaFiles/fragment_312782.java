String sql = "INSERT INTO user(username,password,address) VALUES (?,?,?)";
stmt = conn.prepareStatement(sql);
stmt.setString(1,"11dsa1");
stmt.setString(2,"111");
stmt.setString(3,"111");
stmt.executeUpdate()
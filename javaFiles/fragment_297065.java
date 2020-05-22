String addQuer = "INSERT INTO emaildata VALUES (?,?,?,?,?)";
PreparedStatement ps = conn.prepareStatement(addQuer);
ps.setString(1, email);
ps.setString(2, fname);
ps.setString(3, lname);
ps.setString(4, subject);
ps.setString(5, content);
ps.executeUpdate();
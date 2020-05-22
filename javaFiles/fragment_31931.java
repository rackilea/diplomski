String insert = "INSERT INTO customer(name,address,email) VALUES(?, ?, ?);";
PreparedStatement ps = connection.prepareStatement(insert);
ps.setString(1, name);
ps.setString(2, addre);
ps.setString(3, email);

ResultSet rs = ps.executeQuery();
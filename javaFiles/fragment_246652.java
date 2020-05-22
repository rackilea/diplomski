// con is your active connection

String sqlStatement = "SELECT * FROM student WHERE id = ? OR name LIKE ?";
PreparedStatement prest = con.prepareStatement(sqlStatement);
prest.setString(1, search);
prest.setString(2, search + "%");
ResultSet _set = prest.executeQuery();
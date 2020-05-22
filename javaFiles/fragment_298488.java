String insertNewUserSQL = "INSERT INTO " + studentsTable + " VALUES (?, ?, ?, ?, ?, ?, ?)";
PreparedStatement pstmt = con.prepareStatement(insertNewUserSQL);
pstmt.setString(1, userName);
// ... repeat this step until the last parameter ....
pstmt.setString(7, email);
pstmt.executeUpdate();
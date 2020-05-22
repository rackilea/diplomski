PreparedStatement pStmt = conn.prepareStatement(
    "INSERT INTO T1 VALUES(?, ?, ?)");
pStmt.setString(1, emailId);
pStmt.setString(2, gtse);
pStmt.setDate(3, receivedDate);
pStmt.execute();
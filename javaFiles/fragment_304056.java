Statement stmt = conn.createStatement();
Statement nestedStmt = conn.createStatement(); // add this line       

.
.
.
ResultSet getMsgID = nestedStmt.executeQuery("select msgid from " + newVal ); // Change this line in while loop
.
.
.
// Prepare code for PreparedStatement #1
String varOne = "A";
String varTwo = "B";
String varThree = "C";

String queryOne = "UPDATE blah set x=? y=? z=?"
PreparedStatement firstStmt = conn.prepareStatement(queryOne);

firstStmt.setString(1, varOne);
firstStmt.setString(2, varTwo);
firstStmt.setString(3, varThree);

firstStmt.executeUpdate();
conn.commit();

// Prepare code for PreparedStatement #2
String varOneB = "X";
String varTwoB = "Y";
String varThreeB = "Z";
String varFourB = "A";

String queryOne = "UPDATE blah set a=? b=? c=? d=?"
PreparedStatement secondStmt = conn.prepareStatement(queryTwo);

secondStmt.setString(1, varOneB);
secondStmt.setString(2, varTwoB);
secondStmt.setString(3, varThreeB);

secondStmt.executeUpdate();
conn.commit();
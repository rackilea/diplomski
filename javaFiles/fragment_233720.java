Connection connRemote = null;
Statement InsertRemoteResultsStmt = null;
try {
    connRemote = DriverManager.getConnection("//my urls here");
    // other stuff here
}
catch(SQLException ex) {
    InsertRemoteResultsStmt = connRemote.createStatement(); // error comes here
}
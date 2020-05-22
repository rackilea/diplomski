int i=0; //Declare i outside of your try-catch statement

try{
    ...
    for (String docName : docNames){ 
        preparedStmt.setString (1, docName);
        preparedStmt.addBatch();
        i++;
        if (i % 1000 == 0 || i == docNames.size()) {
            preparedStmt.executeBatch(); 
        }
    }
    ...
}
catch(Exception e){

    String docNameError = docNames.get(i - 1); 
    //subtract 1 from i, because i is only incremented after a successful add 
    //to your prepared statement.

    //use docNameError however you'd like to report the exception

    e.printStackTrace();
}
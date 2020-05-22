String lock = "lock table "+ tableName +" in exclusive mode";
try {
    connection = DriverManager.getConnection(_url, _username, _password);
    connection.setAutoCommit(false);  
    Statement stmt1=connection.createStatement();  
    stmt1.execute(lock);  
    int i = 0;
    while (i<60) {            
        Thread.sleep(1000);    //Sleep one second
        i++;                   
    }
    connection.commit();

} catch (SQLException e) {
    connection.rollback();
    e.printStackTrace();
}
public static void createEmployee(){
    InitialContext initialContext = new InitialContext();
    DataSource datasource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/postgres");
    Connection connection_db= datasource.getConnection();
    try {
        connessione_db.setAutoCommit(false);
        connessione_db.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

        PreparateStatement p1 //Preparate statement to put the employe parameter
        p1.execute();
        //This create another connect 
        createLog("CREATE EMPLOYE", connessione_db);             

        connessione_db.commit();
        //connessione_db.setAutoCommit(true); //No need
    }catch(....){
        try{ connection_db.rollback(); }catch(Exception e){ /*You can also check some flags to avoid exception*/ }
    }finally{
        try{ connection_db.close(); }catch(Exception e){ /*Safe to ignore*/ }
    }
}

public static void createLog(String messaggio, Connection connection_db) {
    try {
        // the code continues with the save operation

    } catch (SQLException s) {

    }
}
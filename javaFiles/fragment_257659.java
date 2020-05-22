Package com.util.dblog;
public class DBLog {

Connection con = null;
PreparedStatement stmt = null;

public DBLog () {
    init();
}

private void init() {
    try {
        DBConnectionHelper connHelper = DBConnectionHelper.createInstance();
        con=connHelper.getConnection("ds"); //Getting connection from connection pool
        con.setAutoCommit(false);
    } catch(Exception e) {}  
}

public void logmethod1(String param1, String param2) { 

    if (con == null || con.isClosed()) {
        init();
    }

    String SQL_PREP_INSERT = "INSERT INTO tableA (LOG_ID,USER_ID,EXEC_TIME) VALUES"             + " (logid_seq.nextval, ?, ?)"; 
    stmt = con.prepareStatement(SQL_PREP_INSERT); 
    stmt.execute();
    stmt.close();
}

public void logmethod2(String param1, String param2, String param3) { 

    if (con == null || con.isClosed()) {
        init();
    }
    ...
    ...
}

public void voidsaveCon() {
    con.commit();
}
public void closeCon() {
    con.close();
}

} //End of DBLog class

From my Java application class, I am calling as follows,

import com.util.dblog;
public class myApp {

    ...
    // in some method
    DBLog log = new DBLog();
    log.logmethod1(param1, param2);
    ....
    log.logmethod2(param1, param2, param3);
    ...

} //End of myApp class
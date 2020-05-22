import java.sql.*;

public class AccessManager {

    private Connection con;
    private Statement st;
    private static final String url="jdbc:odbc:my_access_odbc_dsn";
    private static final String className="sun.jdbc.odbc.JdbcOdbcDriver";
    private static final String user="";
    private static final String pass="";

    AccessManager()throws Exception {
        Class.forName(className);
        con = DriverManager.getConnection(url, user, pass);
        st = con.createStatement(); 
        // you can do select, insert, update, delete from 
    }
}
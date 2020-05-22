import java.sql.*;
public class LoadJdbcOdbcDriver {
  public static void main(String [] args) {
    Connection con = null;
    try {

// Load the JDBC-ODBC bridge driver
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver") ;
      System.out.println("JDBC-ODBC driver loaded ok.");

    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
  }
}
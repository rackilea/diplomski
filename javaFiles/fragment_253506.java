// Java code - main class

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class ArrayExampleMain {

  public static void main(String[] args) throws Exception {
    OracleConnection conn = getOracleConnection().unwrap(OracleConnection.class);
    System.out.println("Got Connection.");

    OracleCallableStatement callStmt = null;

    try {
      callStmt = (OracleCallableStatement)conn.prepareCall("{call add_projects(?)}");

      // create array holding values for ProjectType object's properties
      Object[] project1 = new Object[] {"1", "Title 1"};
      Object[] project2 = new Object[] {"2", "Title 2"};

      // descriptor for OBJECT type defined in database
      StructDescriptor projectTypeDesc = StructDescriptor.createDescriptor("PROJECT_TYPE", conn);

      // each struct is one ProjectType object
      STRUCT structProject1 = new STRUCT(projectTypeDesc, conn, project1);
      STRUCT structProject2 = new STRUCT(projectTypeDesc, conn, project2);

      STRUCT[] structArrayOfProjects = {structProject1, structProject2};

      // descriptor of TABLE type defined in database
      ArrayDescriptor projectTypeArrayDesc = ArrayDescriptor.createDescriptor("MY_ARRAY", conn);

      // array holding two ProjectType objects
      ARRAY arrayOfProjects = new ARRAY(projectTypeArrayDesc, conn, structArrayOfProjects);

      callStmt.setARRAY(1, arrayOfProjects); 
      callStmt.execute();
      conn.commit();

      System.out.println("Committed.");
    } catch (Exception e) {
      if (conn != null) try { conn.rollback(); } catch (Exception ex) { System.out.println("Rollback failed."); }
      throw e;
    } finally {
      callStmt.close();
      conn.close();
     }
  }

  public static Connection getOracleConnection() throws Exception {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@YOUR_HOST:orcl";
    String username = "hr";
    String password = "password";

    Class.forName(driver); // load Oracle driver

    Connection conn = DriverManager.getConnection(url, username, password);

    return conn;
  }
}
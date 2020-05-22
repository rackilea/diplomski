import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CRSetChecker {    
    public static void main(String[] args) {    
        String connectString = "jdbc:oracle:thin:scott/tiger" + 
                "@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)" + 
                "(HOST=myorahost)(PORT=5521))" + 
                "(CONNECT_DATA=(SID=myorasid)))";

        //Get DB connection
        Connection conn = (new CRSet()).getConnection(connectString);
        if (conn == null) {
            System.out.println("Connection failed");

            System.exit(0);
        } else {
            System.out.println("Connection established successfully!");

            try {
                CachedRowSet crs = 
                              RowSetProvider.newFactory().createCachedRowSet(); 
                String query="select ename from emp";
                crs.setCommand(query);
                crs.execute(conn);
                //Set auto commit false
                conn.setAutoCommit(false);
                int count = 0;
                while(crs.next()){
                    String name = crs.getString(1);
                    count++;                        
                    System.out.println(name);
                    if(count==1){                       
                        crs.updateString(1, "COOPER");
                        crs.updateRow();
                        crs.acceptChanges(conn);
                        System.out.println("After update:"+crs.getString(1));
                    }
                }
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } 
        }
    }

    public Connection getConnection(String connectString)
      {
        Connection con = null;
        try {
          try {
            Class.forName("oracle.jdbc.OracleDriver");
          } catch (ClassNotFoundException e) {
            e.printStackTrace();
          }

          con = DriverManager.getConnection(connectString);
        } catch (SQLException ex) {
          ex.printStackTrace();
        }

        return con;
      }
}
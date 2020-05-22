import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestMysql {

    private String dbUrl = "jdbc:mysql://localhost:3306/test";
    private String user = "root";
    private String password = "password";
    private String dbClass = "com.mysql.jdbc.Driver";
    private String query = "SELECT username, email FROM  user_info WHERE MATCH (username, email) AGAINST ('themanager' IN BOOLEAN MODE)";


   @Test
   public void test() {

    try {

        Class.forName(dbClass);
        Connection con = DriverManager.getConnection (dbUrl, user, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String username = rs.getString(1);
            System.out.println("FOUND: '" + username + "'");
        } //end while

        con.close();
    } //end try

    catch(ClassNotFoundException e) {
        e.printStackTrace();
    }

    catch(SQLException e) {
        e.printStackTrace();
    }


  }

}
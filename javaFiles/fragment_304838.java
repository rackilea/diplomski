/**
* Connects to a remote MS-Access DB using JDBC/UCanAccess API.
*/
package miscellaneous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectRemoteDB {
    public static void main(String[] args) {
        initializeConnection();
    }

    /**
    * Initializes remote database connection and inserts a record and closes the connection.
    */
    private static void initializeConnection() {
        System.out.println("Attempting Database Connection...");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager
            .getConnection("jdbc:ucanaccess:////REMOTE-IP-ADDRESS/shared-folder/TestDB.mdb");
            System.out.println("CONNECTION ESTABLISHED....");
            String insertTableSQL = "INSERT INTO Table1" + "(Name) VALUES"
            + "(?)";
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, "Sandeep");
            preparedStatement.executeUpdate();
            System.out.println("RECORD INSERTED...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                System.out.println("CONNECTION CLOSED...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {  // <--- This is missing from your code

    public static void main(String[] args) {
        try {
            String host = "jdbc:derby://localhost:1527/Employees";
            String uName = "faisal";
            String uPass = "password";
            Connection con = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }  // <--- This is also missing from your code
}
package dbms;

import javax.swing.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class StackOverflowExample {

    Connection conn = null;

    public static Connection dbConnector() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\chusm\\workspace\\DBMS\\SQlite\\DBMS.sqlite");
            JOptionPane.showMessageDialog(null, "Connection Successful!!!");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = dbConnector();
    }

}
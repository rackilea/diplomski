/*
 * SQLStatement.java       
 * Simple JDBC Sample using Pervasive JDBC driver. 
 */
import java.*;
import java.sql.*;
import pervasive.jdbc.*;
import java.io.*;


public class SQLStatement  {

    public static void main(String args[]) {

        String url = "jdbc:pervasive://localhost:1583/demodata?transport=tcp";
        Connection con;

        String query = "select* from class";
        Statement stmt;

        try {
            Class.forName("com.pervasive.jdbc.v2.Driver");

        } catch(Exception e) {
            System.err.print("ClassNotFoundException: ");
            System.out.println(e.toString());
            System.err.println(e.getMessage());

        }

        try {
            Connection conn=  DriverManager.getConnection(url);

            stmt = conn.createStatement();                          

            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            long j = 0;
            int i = 1;

            while (rs.next()) {
                System.out.println("Row " + rowCount + ":  ");
                for (i = 1; i <= numberOfColumns; i++) {
                    System.out.print("   Column " + i + ":  ");
                    System.out.println(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            System.out.println("Waiting.");
            String thisLine;
            try {
                InputStreamReader converter = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(converter);
                while ((thisLine = br.readLine()) != null) { // while loop begins here
                    System.out.println(thisLine);
                   } // end while 
                } // end try
            catch (IOException e) {
                System.err.println("Error: " + e);
                }

            stmt.close();
            conn.close();

        } catch(SQLException ex) {
            System.err.print("SQLException: ");
            System.err.println(ex.getMessage());
        }   
    }
}
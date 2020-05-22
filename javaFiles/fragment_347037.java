package com.example.h2localdate;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

/**
 * Hello world!
 */
public class App {
    public static void main ( String[] args ) {
        App app = new App ( );
        app.doIt ( );
    }

    private void doIt ( ) {
        try {
            Class.forName ( "org.h2.Driver" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace ( );
        }

        try (
            Connection conn = DriverManager.getConnection ( "jdbc:h2:mem:trash_me_db_" ) ;
            Statement stmt = conn.createStatement ( ) ;
        ) {
            String tableName = "test_";
            String sql = "CREATE TABLE " + tableName + " (\n" +
                "  id_ UUID DEFAULT random_uuid() PRIMARY KEY ,\n" +
                "  date_ DATE NOT NULL\n" +
                ");";
            stmt.execute ( sql );

            // Insert row.
            sql = "INSERT INTO test_ ( date_ ) " + "VALUES (?) ;";
            try ( PreparedStatement preparedStatement = conn.prepareStatement ( sql ) ; ) {
                LocalDate today = LocalDate.now ( ZoneId.of ( "America/Montreal" ) );
                preparedStatement.setObject ( 1, today.minusDays ( 1 ) );  // Yesterday.
                preparedStatement.executeUpdate ( );
                preparedStatement.setObject ( 1, today );                  // Today.
                preparedStatement.executeUpdate ( );
                preparedStatement.setObject ( 1, today.plusDays ( 1 ) );   // Tomorrow.
                preparedStatement.executeUpdate ( );
            }

            // Query all.
            sql = "SELECT * FROM test_";
            try ( ResultSet rs = stmt.executeQuery ( sql ) ; ) {
                while ( rs.next ( ) ) {
                    //Retrieve by column name
                    UUID id = rs.getObject ( "id_", UUID.class );  // Pass the class to be type-safe, rather than casting returned value.
                    LocalDate localDate = rs.getObject ( "date_", LocalDate.class );  // Ditto, pass class for type-safety.

                    //Display values
                    System.out.println ( "id_: " + id + " | date_: " + localDate );
                }
            }

        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }
}
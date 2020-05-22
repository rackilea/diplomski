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
                preparedStatement.setDate ( 1, java.sql.Date.valueOf ( today.minusDays ( 1 ) ) );  // Yesterday.
                preparedStatement.executeUpdate ( );
                preparedStatement.setDate ( 1, java.sql.Date.valueOf ( today ) );  // Today.
                preparedStatement.executeUpdate ( );
                preparedStatement.setDate ( 1, java.sql.Date.valueOf ( today.plusDays ( 1 ) ) );  // Tomorrow.
                preparedStatement.executeUpdate ( );
            }

            // Query all.
            sql = "SELECT * FROM test_";
            try ( ResultSet rs = stmt.executeQuery ( sql ) ; ) {
                while ( rs.next ( ) ) {
                    //Retrieve by column name
                    UUID id = ( UUID ) rs.getObject ( "id_" );  // Cast the `Object` object to UUID if your driver does not support JDBC 4.2 and its ability to pass the expected return type for type-safety.
                    java.sql.Date sqlDate = rs.getDate ( "date_" );
                    LocalDate localDate = sqlDate.toLocalDate ();  // Immediately convert into java.time. Mimimize use of java.sql types.

                    //Display values
                    System.out.println ( "id_: " + id + " | date_: " + localDate );
                }
            }

        } catch ( SQLException e ) {
            e.printStackTrace ( );
        }
    }
}
package com.basilbourque.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class EventDate {
    public static void main ( String[] args ) {
        EventDate app = new EventDate();
        app.doIt();
    }

    private void doIt ( ) {
        final String driverName = "org.h2.Driver";
        final String catalogName = "event_demo_db";
        final String jdbcPath = "jdbc:h2:mem:" + catalogName + ";DB_CLOSE_DELAY=-1";  // Set delay to keep in-memory database even after last connection closed.

        // Verify JDBC driver.
        try {
            Class.forName( driverName );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }

        // Connect, and create database.
        try (
                Connection conn = DriverManager.getConnection( jdbcPath ) ;
        ) {
            String sql = null;

            // Create table.
            try ( Statement stmt = conn.createStatement() ; ) {
                sql = "CREATE TABLE " + "event_" + " ( \n" +
                        " pkey_ IDENTITY PRIMARY KEY , \n" +
                        " when_ DATE NOT NULL \n" +
                        ") ; \n";
                System.out.println( "TRACE - SQL:\n" + sql );
                stmt.execute( sql );
            }
            System.out.println( "TRACE - Created table `event_`." );

            // Add rows
            sql = "INSERT INTO event_ ( when_ ) \n" +
                    "VALUES ( ? ) " +
                    "; ";

            List < LocalDate > dates = List.of( LocalDate.parse( "2018-11-10" ) , LocalDate.parse( "2018-12-31" ) );
            System.out.println( "Inserting list of LocalDate objects: " + dates );
            try (
                    PreparedStatement ps = conn.prepareStatement( sql ) ;
            ) {
                for ( LocalDate localDate : dates ) {
                    ps.setObject( 1 , localDate );
                    ps.executeUpdate();
                }
            }

            // Retrieve rows
             sql = "SELECT * FROM " + "event_" + " ;";
            try (
                    Statement stmt = conn.createStatement() ;
                    ResultSet rs = stmt.executeQuery( sql ) ;
            ) {
                while ( rs.next() ) {
                    int pkey = rs.getInt( "pkey_" );
                    LocalDate when = rs.getObject( "when_" , LocalDate.class );
                    System.out.println( "Row pkey_: " + pkey + " when_: " + when );
                }
            }


        } catch ( SQLException e ) {
            e.printStackTrace();
        }

    }
}
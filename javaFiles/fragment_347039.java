package work.basil.example;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

public class LocalDateMin
{
    public static void main ( String[] args )
    {
        LocalDateMin app = new LocalDateMin();
        app.doIt();
    }

    private void doIt ()
    {
        org.h2.jdbcx.JdbcDataSource ds = new org.h2.jdbcx.JdbcDataSource();
        ds.setURL( "jdbc:h2:mem:localdate_min_example_db_;DB_CLOSE_DELAY=-1" );
        ds.setUser( "scott" );
        ds.setPassword( "tiger" );

        try (
                Connection conn = ds.getConnection() ;
                Statement stmt = conn.createStatement() ;
        )
        {
            String tableName = "test_";
            String sql = "CREATE TABLE " + tableName + " (\n" +
                    "  id_ UUID DEFAULT random_uuid() PRIMARY KEY ,\n" +
                    "  date_ DATE NOT NULL\n" +
                    ");";
            stmt.execute( sql );

            // Insert row.
            sql = "INSERT INTO test_ ( date_ ) " + "VALUES (?) ;";
            try ( PreparedStatement preparedStatement = conn.prepareStatement( sql ) ; )
            {
                LocalDate today = LocalDate.now( ZoneId.of( "America/Montreal" ) );
                preparedStatement.setObject( 1 , LocalDate.MIN );  // MIN =
                preparedStatement.executeUpdate();
            }

            // Query all.
            sql = "SELECT * FROM test_";
            try ( ResultSet rs = stmt.executeQuery( sql ) ; )
            {
                while ( rs.next() )
                {
                    //Retrieve by column name
                    UUID id = rs.getObject( "id_" , UUID.class );  // Pass the class to be type-safe, rather than casting returned value.
                    LocalDate localDate = rs.getObject( "date_" , LocalDate.class );  // Ditto, pass class for type-safety.

                    //Display values
                    System.out.println( "id_: " + id + " | date_: " + localDate );
                }
            }

        } catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
}
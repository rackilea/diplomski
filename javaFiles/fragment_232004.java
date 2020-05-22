import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

public class Start
{
    public static void main( String[] args ) throws InterruptedException, SQLException
    {
        try
        {
            Class.forName( "org.postgresql.Driver" );
        }
        catch ( ClassNotFoundException e )
        {
            System.out.println( "Where is your JDBC Driver?" );
            e.printStackTrace();
            return;
        }

        System.out.println( "Registered JDBC driver" );
        Connection connection = null;

        try
        {
            final String databaseUrl = "jdbc:postgresql://localhost:5483/postgres";
            final Properties properties = new Properties();
            connection = DriverManager.getConnection( databaseUrl, properties );
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            // Default fetch size of 0 does not create a cursor.
            // Method executeQuery will retrieve all rows in result set.
            statement.setFetchSize( 0 );

            // Fetch size of 1 creates a cursor with batch size of 1.
            // Method executeQuery will retrieve only 1 row in the result set.
            //statement.setFetchSize( 1 );

            System.out.println( new Date() + ": Before execute query" );
            ResultSet result =
                statement.executeQuery( "select * from test" );
            System.out.println( new Date() + ": After execute query" );
            System.out.println( new Date() + ": Sleep for 5 s" );
            Thread.sleep( 5000 );
            System.out.println( new Date() + ": Before process result set" );
            while ( result.next() );
            System.out.println( new Date() + ": After process result set" );
            result.close();
            statement.close();
        }
        catch ( SQLException e )
        {
            System.out.println( "Connection failed!" );
            e.printStackTrace();
            return;
        }
        finally
        {
            if ( connection != null )
                connection.close();
        }
    }
}
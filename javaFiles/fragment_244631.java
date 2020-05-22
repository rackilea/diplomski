public class myConnection 
{

// JDBC driver name and database URL
private static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
private static final String DATABASE_URL ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=.\\database.accdb";

// declare Connection for accessing and querying database
private Connection connection;


// constructor connects to database
public myConnection () 
{ 
    try 
    {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL);

    } 

    catch (SQLException sqlException)
    {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);

        System.exit(1);
    }

    catch (ClassNotFoundException classNotFound)
    {
        JOptionPane.showMessageDialog(null, classNotFound.getMessage(),
                "Driver Not Found", JOptionPane.ERROR_MESSAGE);

        System.exit(1);
    }
}

public void closeConnection()
{
    try 
    {
        connection.close();
    }

    catch (SQLException sqlException)
    {
        JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);

        System.exit(1);
    }
}

public Connection getConnection()
{
    return connection;
}
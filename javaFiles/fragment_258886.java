public class ConnectionClass
{
    public static Connection connection = null;

    public Connection getCurrentConnection()
    {
        if(connection != null)
        {
            return connection;
        }
        else
        {
            create new connection...
                    and return that new connection after giving it to global connection..
        }
    }
}
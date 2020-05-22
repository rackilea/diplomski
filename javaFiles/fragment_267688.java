import java.sql.Connection;
import java.sql.DriverManager;

public class V9
{
    public static final String driver = "org.postgresql.Driver";
    public static final String url = "jdbc:postgresql://localhost:5432/party";
    public static final String username = "pgsuper";
    public static final String password = "pgsuper";

    public static void main(String [] args)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn.getMetaData().getDatabaseProductName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
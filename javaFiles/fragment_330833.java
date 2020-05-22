package DB;
import java.sql.*;
public class DataBaseConnection {
    public Connection connet() {
        Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","sukanth","");
        }
        catch(Exception e)
        {
            e.printStacktrace();
        }
        return con;
    }
}
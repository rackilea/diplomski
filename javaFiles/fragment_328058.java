import java.sql.*;

public class TestConnection
{
    public static void main(String[] args)
    {
        DB db = new DB();
        db.dbConnect("jdbc:sqlserver://LAPTOP-INSPIRON\\SQLEXPRESS:1435;databaseName=i2b2_demo;integratedSecurity=true;","i2b2","i2b2");
    }
}

class DB
{
    public DB() {}

    public void dbConnect(String db_connect_string, String db_userid, String db_password)
    {
        try
        {
            Connection conn = DriverManager.getConnection(db_connect_string, db_userid, db_password);
            System.out.println("connected");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
};
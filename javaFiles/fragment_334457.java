import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class informix_trace
    {
    public static void main(String[] args)
        {
        try
            {
            Class.forName("com.informix.jdbc.IfxDriver");
            FileWriter fwTrace = new FileWriter("c:\\JDBCTrace.log");
            PrintWriter pwTrace = new PrintWriter(fwTrace);
            DriverManager.setLogWriter(pwTrace);
            String debug_url = "SQLIDEBUG=C:\\sqlidebug.trace";
            String url = "jdbc:informix-sqli://1.2.3.4:9088/test_db:informixserver=ol_testifx;DB_LOCALE=pl_PL.CP1250;CLIENT_LOCALE=pl_PL.CP1250;charSet=CP1250;" + debug_url
            Connection connection = DriverManager.getConnection(url, "user", "passwd");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT FIRST 1 DBINFO('version','full') FROM systables;");
            while (resultSet.next())
                System.out.println(resultSet.getObject(1));
            }
        catch (Exception e)
            {
            e.printStackTrace();
            }
        }

    } // class informix_trace
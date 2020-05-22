import java.sql.*;

public class JDBCQuery {
    public static void main( String args[] )
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\Users\\Public\\Database1.accdb;");
            Statement s = conn.createStatement();
            s.execute("CREATE TABLE [TESTME] ([column_name] integer)");
            s.execute("INSERT INTO [TESTME] VALUES (3)");
            s.execute("SELECT [column_name] FROM [TESTME]");
            ResultSet rs = s.getResultSet();
            if (rs!=null)
            {
                while (rs.next())
                {
                    System.out.println("Data from column_name: " + rs.getString(1));
                }
            }
            s.execute("DROP TABLE [TESTME]");
            s.close();
            conn.close();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
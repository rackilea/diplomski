import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBconnect {
    static String url = "jdbc:mysql://localhost:3306/ppmgt";
    Connection conn;
    Statement st;

    public DBconnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void putdata(String sql) throws Exception {
        st = this.conn.createStatement();
        st.executeUpdate(sql);
    }

    public ResultSet getdata(String sql) throws Exception {
        Statement st = this.conn.createStatement();
        return st.executeQuery(sql);
    }

    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static long compareTo(Date date1, Date date2) {
        return date1.getTime() - date2.getTime();
    }
}
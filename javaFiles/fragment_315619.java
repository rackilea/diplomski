import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class SqlOut {

    public static Connection getConnection(String url, String user, String pw) throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", pw);
        conn = DriverManager.getConnection(url, connectionProps);
        return conn;
    }

    private static String coalesce(Object o, String nullValue)
    {
        if(o==null)
            return nullValue;
        return o.toString();
    }
    /**
     * 
     * @param args
     * [0] : jdbc connection url
     * [1] : JDBC driver class name
     * [2] : database user
     * [3] : database password
     * [4] : SQL statement
     * [5] : output file name
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Class.forName(args[1]);
        Connection conn = getConnection(args[0], args[2], args[3]);
        PreparedStatement ps = conn.prepareStatement(args[4]);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmeta = rs.getMetaData();
        File outfile=new File(args[5]);
        try (FileWriter fos = new FileWriter(new File(args[5]))) {
            // export column names
            for (int ci = 1; ci <= rsmeta.getColumnCount(); ci++) {
                if (ci > 1)
                    fos.write(";");
                fos.write(rsmeta.getColumnLabel(ci));
            }
            fos.write("\n");
            while (rs.next()) {
                for (int ci = 1; ci <= rsmeta.getColumnCount(); ci++) {
                    if(ci > 1)
                        fos.write(";");
                    fos.write(coalesce(rs.getObject(ci),""));
                }
                fos.write("\n");
            }
        }
        System.out.println("CSV file written to "+outfile.getAbsolutePath());
    }
}
public class MysqlSample01Activity extends Activity {

private static final String url = "jdbc:mysql://<server>:<port>/<database>";
private static final String user = "<your username>";
private static final String pass = "<your password>";

/** This will run when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    connectToDB();
}

public void connectToDB() {
    ...
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        System.out.println("Database connection was successful");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from table_name");
        ResultSetMetaData rsmd = rs.getMetaData();

        while(rs.next()) {
            result += rsmd.getColumnName(1) + ": " + rs.getInt(1) + "\n";
            result += rsmd.getColumnName(2) + ": " + rs.getString(2) + "\n";
        }
        ...
    }
    catch(Exception e) {
        e.printStackTrace();
        tv.setText(e.toString());
    }   

}
}
public class JavaApplication {

private static final String DATABASE_URL = "jdbc:mysql://localhost/test?characterEncoding=utf8";
private static final String DATABASE_USER = "root";
private static final String DATABASE_PASSWORD = "";
private static Connection con;
public static void main(String[] args) {
    try {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl(DATABASE_URL);
        ds.setUser(DATABASE_USER);
        ds.setPassword(DATABASE_PASSWORD);
        con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO tablename (date) VALUES (?)");
        ps.setTimestamp(1, date);
        ps.executeUpdate();
        ps = con.prepareStatement("SELECT * FROM tablename");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("Date in database: "+rs.getTimestamp("date"));
            System.out.println("Time difference between server and database record in seconds: "+(rs.getTimestamp("date").getTime()-System.currentTimeMillis())/1000);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
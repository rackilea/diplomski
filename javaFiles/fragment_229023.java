public class connectjava {
    Connection conn= null;

public static Connection ConnecrDb(){
    try {

        Class.forName("org.sqlite.JDBC");
        Connection conn=DriverManager.getConnection("jdbc:sqlite://ThePathToYourDatabase/TheNameOfYourDatabase.db");
        return conn;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
}

public Connection getConn() {
    return conn;
}

public void setConn(Connection conn) {
    this.conn = conn;
}
}
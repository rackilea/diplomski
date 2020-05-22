public class Dummy extends Thread {
private volatile Connection conn = null;
@Override
public void run() {
    try {
        this.conn = DriverManager.getConnection("foobar") ;
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
static public Connection getConnection() {
    Dummy d = new Dummy() ;
    d.start() ;
    try {
        Thread.sleep(2000) ;
    } catch (InterruptedException e) {}
    return d.conn ;
}
}
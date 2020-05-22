import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DataSource {

    private String driverClass;
    private String jdbcUrl;
    private String user;
    private String password;
    private int min; // The number of connections of initial pool
    private int max;
    private int used; // The number of connections of polled and not released from poll
    private Queue<Connection> pool = null;

    public DataSource(String driverClass, String jdbcUrl, String user, String password, int min, int max) {
        this.driverClass = driverClass;
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
        this.min = min;
        this.max = max;
        this.used = 0;
        this.pool = new ConcurrentLinkedQueue<Connection>();
        init();
    }

    private void init() {
        try {
            Class.forName(driverClass);
            for (int i = 0; i < min; i++) {
                Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
                pool.add(conn);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn  = null;
        if (pool.size() > 0) {
            conn = pool.poll();
            Thread connGen = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
                        pool.add(conn);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            connGen.start();
            used ++;
        } else if(used < max) {
            try {
                conn = DriverManager.getConnection(jdbcUrl, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void releaseConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                used--;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
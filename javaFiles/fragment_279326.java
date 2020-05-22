import java.sql.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Creates an SQL Server deadlock.
 *
 * <pre>
   javac SQLServerDeadlock.java && java -cp ".:sqljdbc.jar" SQLServerDeadlock <server> <db-name> <username> <password>
 * </pre>
 */
public class SQLServerDeadlock {
    static String server, db, user, pw;
    static String TABLE_A = "TABLE_A", TABLE_B = "TABLE_B";
    static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String... args) throws SQLException {
        server = args[0];
        db     = args[1];
        user   = args[2];
        pw     = args[3];
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = getConnection();
            init(connection);
            Thread t1 = new Thread(new Update(TABLE_A, TABLE_B), "A-THEN-B");
            Thread t2 = new Thread(new Update(TABLE_B, TABLE_A), "B-THEN-A");
            if (Math.random() < .5) {
                t1.start();
                t2.start();
            } else {
                t2.start();
                t1.start();
            }
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            cleanup(connection);
        }
    }

    static class Update implements Runnable {
        String table1;
        String table2;

        Update(String table1, String table2) {
            this.table1 = table1;
            this.table2 = table2;
        }

        @Override
        public void run() {
            Connection connection = null;
            try {
                connection = getConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE " + table1 + " SET FOO=1");
                latch.countDown();
                latch.await();
                statement.executeUpdate("UPDATE " + table2 + " SET FOO=1");
                connection.commit();
                System.err.println(Thread.currentThread().getName() + ": SUCCESS!");
            } catch (SQLException sqle) {
                if (sqle.getMessage().contains("Rerun the transaction")) {
                    System.err.println(Thread.currentThread().getName() + ": DEADLOCK VICTIM!");
                }
                System.err.println(sqle);
            } catch (InterruptedException ie) {
                System.err.println(ie);
            } finally {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    System.err.println(sqle);
                }
            }
        }
    }

    static void init(Connection connection) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            for (String tableName : Arrays.asList(TABLE_A, TABLE_B)) {
                if (tableExists(connection, tableName)) {
                    statement.execute("DROP TABLE " + tableName);
                }
                statement.execute("CREATE TABLE " + tableName + " (FOO INTEGER)");
                statement.execute("INSERT INTO  " + tableName + " VALUES (0)");
            }
            connection.commit();
        } finally {
            statement.close();
        }
    }

    static void cleanup(Connection connection) throws SQLException {
        if (connection == null) {
            return;
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
            for (String tableName : Arrays.asList(TABLE_A, TABLE_B)) {
                if (tableExists(connection, tableName)) {
                    statement.execute("DROP TABLE " + tableName);
                }
            }
            connection.commit();
        } finally {
            statement.close();
        }
    }

    static boolean tableExists(Connection connection, String tableName) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql =
                " SELECT TABLE_NAME                         " +
                "   FROM INFORMATION_SCHEMA.TABLES          " +
                "  WHERE TABLE_CATALOG = '" + db        + "'" +
                "    AND TABLE_NAME    = '" + tableName + "'";
            ResultSet rs = statement.executeQuery(sql);
            return rs.next();
        } finally {
            statement.close();
        }
    }

    static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://" + server + ";databaseName=" + db + ";", user, pw);
        connection.setAutoCommit(false);
        return connection;
    }
}
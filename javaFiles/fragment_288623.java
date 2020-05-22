package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * DonkeyInsert changes
 * @author Michael
 * @link https://stackoverflow.com/questions/32551895/write-time-in-mysql?noredirect=1#comment52959887_32551895
 * @since 9/13/2015 12:49 PM
 */
public class DonkeyInsert {

    public static final int DEFAULT__RECORD_COUNT = 6000;

    private Random random;

    public DonkeyInsert() {
        this.random = new Random();
    }

    public DonkeyInsert(long seed) {
        this.random = new Random(seed);
    }

    public static void main(String[] args) {
        // I'd externalize these so I could change the database without recompiling.
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://hostname:3306/dbname";
        String username = "username";
        String password = "password";
        Connection connection = null;
        try {
            DonkeyInsert donkeyInsert = new DonkeyInsert();
            connection = createConnection(driver, url, username, password);
            int numRowsInserted = donkeyInsert.insertPins(connection, DEFAULT__RECORD_COUNT);
            System.out.println(String.format("# pins inserted: %d", numRowsInserted));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }

    private static final String INSERT_SQL =  "INSERT INTO login(pin) VALUES(?) ";

    public int insertPins(Connection connection, int count) {
        int numInserted = 0;
        if (count > 0) {
            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement(INSERT_SQL);
                for (int i = 0; i < count; ++i) {
                    ps.setString(1, this.createRandomPin());
                    ps.addBatch();
                }
                int [] counts = ps.executeBatch();
                for (int rowCount : counts) {
                    numInserted += rowCount;
                }
            } catch (SQLException e) {
                throw new RuntimeException("SQL exception caught while inserting pins", e);
            } finally {
                close(ps);
            }
        }
        return numInserted;
    }

    public String createRandomPin() {
        // Changed it a bit.  Didn't understand your requirement.
        int k = this.random.nextInt(Integer.MAX_VALUE);
        return Integer.toString(k);
    }



    public static Connection createConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        if ((username == null) || (password == null) || (username.trim().length() == 0) || (password.trim().length() == 0)) {
            return DriverManager.getConnection(url);
        } else {
            return DriverManager.getConnection(url, username, password);
        }
    }


    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
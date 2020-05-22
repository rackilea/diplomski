import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

// create table x_tst_ts_tab(
// os_name varchar(256)
// ts timestamp,
// ts_with_tz timestamp with time zone,
// ts_with_local_tz timestamp with local time zone
// )
class TSTest {
    public static final void main(String[] argv) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = DriverManager.getConnection(
            "your_connection_string",
            "your_user_name",
            "your_password");

        try {
            // Insert some data
            Date nowDate = new Date();
            Timestamp nowTimestamp = new Timestamp(nowDate.getTime());
            PreparedStatement insertStmt = conn.prepareStatement(
                "INSERT INTO x_tst_ts_tab"
                + " (os_name, ts, ts_with_tz, ts_with_local_tz)"
                + " VALUES (?, ?, ?, ?)");
            try {
                insertStmt.setString(1, System.getProperty("os.name"));
                insertStmt.setTimestamp(2, nowTimestamp);
                insertStmt.setTimestamp(3, nowTimestamp);
                insertStmt.setTimestamp(4, nowTimestamp);
                insertStmt.executeUpdate();
            } finally {
                try {
                    insertStmt.close();
                } catch (Throwable t) {
                    // do nothing
                }
            }

            System.out.println("os_name, ts, ts_with_tz, ts_with_local_tz");

            // Read back everything in the DB
            PreparedStatement selectStmt = conn.prepareStatement(
                "SELECT os_name, ts, ts_with_tz, ts_with_local_tz"
                + " FROM dom_fraud_beacon.x_tst_ts_tab");
            ResultSet result = null;
            try {
                result = selectStmt.executeQuery();
                while (result.next()) {
                    System.out.println(
                        String.format("%s,%s,%s,%s",
                                      result.getString(1),
                                      result.getTimestamp(2).toString(),
                                      result.getTimestamp(3).toString(),
                                      result.getTimestamp(4).toString()
                                      ));
                }
            } finally {
                try {
                    result.close();
                } catch (Throwable t) {
                    // do nothing
                } finally {
                    try {
                        selectStmt.close();
                    } catch (Throwable t) {
                        // do nothing
                    }
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Throwable t) {
                // do nothing
            }
        }
    }
}
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCXYDataset;

/**
 * @see http://stackoverflow.com/a/24762078/230513
 */
public class JDBCTest {

    private static final int N = 24;
    private static final Random r = new Random();

    private void display() {
        JFrame f = new JFrame("JDBCTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDBCXYDataset jds = createDataset();
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Inventory", "Date", "Count", jds, true, true, false);
        f.add(new ChartPanel(chart));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        for (int i = 0; i < jds.getItemCount(); i++) {
            System.out.println(DateFormat.getDateTimeInstance()
                .format(new Date(jds.getX(0, i).longValue())));
        }
    }

    private JDBCXYDataset createDataset() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:test", "", "");
            Statement st = conn.createStatement();
            st.execute("create table inventory(when timestamp, n1 integer, n2 integer)");
            PreparedStatement ps = conn.prepareStatement(
                "insert into inventory values (?, ?, ?)");
            Calendar c = Calendar.getInstance();
            for (int i = 0; i < N; i++) {
                ps.setTimestamp(1, new Timestamp(c.getTimeInMillis()));
                ps.setInt(2, N / 3 + r.nextInt(N / 2));
                ps.setInt(3, N / 2 + r.nextInt(N / 2));
                ps.execute();
                c.add(Calendar.HOUR_OF_DAY, 1);
            }
            JDBCXYDataset jds = new JDBCXYDataset(conn);
            jds.executeQuery("select when, n1, n2 from inventory");
            return jds;
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JDBCTest().display();
            }
        });
    }
}
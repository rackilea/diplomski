import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @see https://stackoverflow.com/q/46669145/230513
 */
public class TableTest {

    private static final int N = 16;

    private void display() {
        JFrame f = new JFrame("TableTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel(
            null, new String[]{"Variable", "Value"}
        );
        JTable table = new JTable(model) {

            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(256, getRowHeight() * N / 2);
            }
        };
        for (int i = 0; i < N; i++) {
            model.addRow(new Object[]{"V_L1_N_RMS_AVG" + i, String.valueOf(i)});
        }
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(table);
        JTabbedPane jtp = new JTabbedPane();
        jtp.add("TableTest", jsp);
        f.add(jtp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new TableTest()::display);
    }
}
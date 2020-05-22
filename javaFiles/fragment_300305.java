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

    private void display() {
        JFrame f = new JFrame("TableTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][]{{"V_L1_N_RMS_AVG", null}},
            new String[]{"Variable", "Value"}
        ));
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
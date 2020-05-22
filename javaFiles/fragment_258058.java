import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class TestTable {

    public JFrame f;
    private JTable table;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }

    protected void initUI() {
        String[][] data = new String[1][1];
        data[0] = new String[] { "hello" };
        String[] columns = new String[] { "Column-1", "Column-2" };
        table = new JTable(data, columns);
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }

}
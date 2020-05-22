import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ListSelectionListenerExample extends JPanel {
    private static final int TABLE_COUNT = 4;
    private static final Integer[][] DATA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private static final String[] COL_NAMES = {"A", "B", "C"};

    public ListSelectionListenerExample() {
        ListSelectionGroup listSelectionGroup = new ListSelectionGroup();
        setLayout(new GridLayout(1, 0));
        for (int i = 0; i < TABLE_COUNT; i++) {
            DefaultTableModel model = new DefaultTableModel(DATA, COL_NAMES);
            JTable table = new JTable(model);
            ListSelectionModel selectionModel = table.getSelectionModel();
            listSelectionGroup.register(selectionModel);
            add(new JScrollPane(table));
        }
    }

    private static void createAndShowGui() {
        ListSelectionListenerExample mainPanel = new ListSelectionListenerExample();

        JFrame frame = new JFrame("ListSelectionListener Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
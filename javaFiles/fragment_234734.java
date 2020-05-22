import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NoMouseListenerNeeded extends JPanel {
    private static final Integer[][] DATA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    private static final String[] COLS = { "A", "B", "C" };
    private DefaultTableModel tblModel = new DefaultTableModel(DATA, COLS);
    private JTable table = new JTable(tblModel);

    public NoMouseListenerNeeded() {
        JPanel btnPanel = new JPanel();
        btnPanel.add(new JButton(new MyButtonListener(this)));

        setLayout(new BorderLayout());
        add(new JScrollPane(table));
        add(btnPanel, BorderLayout.PAGE_END);
    }

    // get data held by selected cell in JTable
    // returns null if no cell selected
    public Object getSelectedCell() {
        int col = table.getSelectedColumn();
        int row = table.getSelectedRow();

        if (col < 0 || row < 0) {
            return null; // no selection made, return null
        } else {
            return table.getValueAt(row, col);
        }
    }

    private static void createAndShowGui() {
        NoMouseListenerNeeded mainPanel = new NoMouseListenerNeeded();

        JFrame frame = new JFrame("NoMouseListenerNeeded");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}
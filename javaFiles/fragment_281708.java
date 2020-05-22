import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableExample extends JFrame {

    private JFrame frmLeaderboards;
    private JTable leaderboard_table;

    public static void main(String[] args) {
        TableExample leaderboardTable = new TableExample();
        leaderboardTable.show_table_screen();
    }

    public void show_table_screen() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmLeaderboards.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TableExample() {
        initialize();
    }

    @SuppressWarnings("serial")
    private void initialize() {
        frmLeaderboards = new JFrame();
        frmLeaderboards.setTitle("Leaderboards");
        frmLeaderboards.setBounds(100, 100, 485, 218);
        frmLeaderboards.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] data = getData();

        String[] column_names = {
            "Rank",
            "Name",
            "Time"
        };

        leaderboard_table = new JTable(data, column_names);

        DefaultTableModel model = getTableModel(data, column_names);

        leaderboard_table.setModel(model);

        leaderboard_table.setFont(new Font("Consolas", Font.PLAIN, 12));

        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(leaderboard_table);
        scrollPane.setBounds(36, 37, 407, 79);
        frmLeaderboards.add(scrollPane);
    }

    private DefaultTableModel getTableModel(Object[][] data, String[] column_names) {
        return new DefaultTableModel(data, column_names) {
                boolean[] columnEditables = new boolean[] { false, false, false };
                public boolean isCellEditable(int row, int column) {
                    return columnEditables[column];
                }
            };
    }

    private Object[][] getData() {
        return new Object[][] {
                {"Kathy", "Smith",
                    "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                    "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                    "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                    "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                    "Pool", new Integer(10), new Boolean(false)}
            };
    }
}
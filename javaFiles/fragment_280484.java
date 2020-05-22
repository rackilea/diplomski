import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestGUI {

    private JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestGUI window = new TestGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TestGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(60, 81, 311, 96);

        frame.getContentPane().add(scrollPane);

        String[] columnNames = { "column1", "column2", "columnN" };
        String[][] tableData = new String[1][columnNames.length];
        table = new JTable(tableData, columnNames);
        DefaultTableModel model = new DefaultTableModel(2, columnNames.length);
        model.addRow(new String[] { "A", "B", "C" });
        table.setModel(model);

        scrollPane.setViewportView(table);

        JButton btnNewButton = new JButton("update");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new String[] { "A", "B", "D" });

            }
        });
        btnNewButton.setBounds(49, 199, 89, 23);
        frame.getContentPane().add(btnNewButton);
    }
}
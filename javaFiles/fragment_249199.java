import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class QuickTable {

    public static void main(String[] args) {
        new QuickTable();
    }

    public QuickTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTable table = new JTable();
                DefaultTableModel tableModel = new DefaultTableModel();

                tableModel.addColumn("Naam");
                tableModel.addColumn("Achternaam");
                tableModel.addColumn("Klant-ID");

                for (int index = 0; index < 10; index++) {

                    String value = Integer.toString(index);
                    tableModel.addRow(new Object[]{value, value, value});

                }

                table.setModel(tableModel);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
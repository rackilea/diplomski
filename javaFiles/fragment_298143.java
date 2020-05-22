import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class DemoTable3 {
    private static void createAndShowUI() {
        JFrame frame = new JFrame("DemoTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] rows = { { "Column 1", "Column 2" },
                { "Column 1", "Column 2" } };
        Object[] columns = { "Column 1", "Column 2" };

        DefaultTableModel model = new DefaultTableModel(rows, columns);
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println("apply additional action");
            }
        });

        JTable table = new JTable(model);
        frame.add(new JScrollPane(table));
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}
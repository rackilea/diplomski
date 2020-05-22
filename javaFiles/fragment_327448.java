import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestTable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String[][] data = { { "Data", "Data" } };
                String[] col = { "Col", "Col" };
                final DefaultTableModel model = new DefaultTableModel(data, col);
                JTable table = new JTable(model);
                JButton addRow = new JButton("Add Empty Row");
                addRow.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        model.addRow(new Object[] {});
                    }
                });
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(new JScrollPane(table));
                panel.add(addRow, BorderLayout.SOUTH);
                JOptionPane.showMessageDialog(null, panel);
            }
        });
    }
}
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

public class RemoveAddRows extends JFrame {

    private static final long serialVersionUID = 1L;
    private Object[] columnNames = {"Type", "Company", "Shares", "Price"};
    private Object[][] data = {
        {"Buy", "IBM", new Integer(1000), new Double(80.50)},
        {"Sell", "MicroSoft", new Integer(2000), new Double(6.25)},
        {"Sell", "Apple", new Integer(3000), new Double(7.35)},
        {"Buy", "Nortel", new Integer(4000), new Double(20.00)}
    };
    private JTable table;
    private DefaultTableModel model;
    private javax.swing.Timer timer = null;

    public RemoveAddRows() {
        model = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (isRowSelected(row) && isColumnSelected(column)) {
                    ((JComponent) c).setBorder(new LineBorder(Color.red));
                }
                return c;
            }
        };
        ListSelectionModel rowSelMod = table.getSelectionModel();
        rowSelMod.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                String str = "Selected Row(s): ";
                int[] rows = table.getSelectedRows();
                for (int i = 0; i < rows.length; i++) {
                    str += rows[i] + " ";
                }
                str += "Selected Column(s): ";
                int[] cols = table.getSelectedColumns();
                for (int i = 0; i < cols.length; i++) {
                    str += cols[i] + " ";
                }
                str += "Selected Cell: " + table.getSelectedRow() + ", " + table.getSelectedColumn();
                System.out.println(str);
                Object value = table.getValueAt(row, col);
                System.out.println(String.valueOf(value));
            }
        });
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        JButton button1 = new JButton("Remove all rows");
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                System.out.println("model.getRowCount() --->" + model.getRowCount());
            }
        });
        JButton button2 = new JButton("Add new rows");
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                start();
            }
        });
        JPanel southPanel = new JPanel();
        southPanel.add(button1);
        southPanel.add(button2);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void start() {
        timer = new javax.swing.Timer(2500, updateCol());
        timer.start();
    }

    public Action updateCol() {
        return new AbstractAction("text load action") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Object[] data0 = {"Buy", "IBM", new Integer(1000), new Double(80.50)};
                model.addRow(data0);
                Object[] data1 = {"Sell", "MicroSoft", new Integer(2000), new Double(6.25)};
                model.addRow(data1);
                Object[] data2 = {"Sell", "Apple", new Integer(3000), new Double(7.35)};
                model.addRow(data2);
                Object[] data3 = {"Buy", "Nortel", new Integer(4000), new Double(20.00)};
                model.addRow(data3);
                System.out.println("model.getRowCount() --->" + model.getRowCount());
                timer.stop();
                int rowIndex = table.getRowCount() - 1;
                table.changeSelection(rowIndex, 0, false, false);
            }
        };
    }

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                RemoveAddRows frame = new RemoveAddRows();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
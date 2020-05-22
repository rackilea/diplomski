import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TestTable {

    public static void main(String[] args) {
        new TestTable();
    }

    public TestTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final DefaultTableModel model = new DefaultTableModel(
                        new Object[]{"A", "B", "C"}, 
                        0
                );

                model.addRow(new Object[]{"A", "B", "1"});
                model.addRow(new Object[]{"C", "D", "0"});
                model.addRow(new Object[]{"E", "F", "1"});
                model.addRow(new Object[]{"G", "H", "0"});

                JTable table = new JTable(model);
                table.setDefaultRenderer(Object.class, new MyCellRenderer());

                JButton btn = new JButton("Add");
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.addRow(new Object[]{"N", "O", (int)(Math.round(Math.random() * 1))});
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.add(btn, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyCellRenderer extends javax.swing.table.DefaultTableCellRenderer {

        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            final java.awt.Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            Object val = table.getValueAt(row, 2);
            String sval = val.toString();
            sval = sval.replaceAll(":", "");
            int ival = Integer.parseInt(sval);
            if (ival == 0) {
                cellComponent.setForeground(Color.black);
                cellComponent.setBackground(Color.red);

            } else {
                cellComponent.setBackground(Color.white);
                cellComponent.setForeground(Color.black);
            }
            if (isSelected) {
                cellComponent.setForeground(table.getSelectionForeground());
                cellComponent.setBackground(table.getSelectionBackground());
            }

            return cellComponent;

        }

    }

}
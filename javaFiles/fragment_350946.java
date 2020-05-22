import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class JComboBoxInJTable {

    public static void main(String[] args) {
        new JComboBoxInJTable();
    }

    private List<String> comboData;

    public JComboBoxInJTable() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            DefaultTableModel model = new DefaultTableModel(new Object[]{"ComboBox", "Index"}, 1) {

                @Override
                public void setValueAt(Object aValue, int row, int column) {
                    super.setValueAt(aValue, row, column);
                    if (column == 0) {
                        String value = aValue == null ? null : aValue.toString();
                        if (aValue == null) {
                            super.setValueAt(null, row, 1);
                        } else {
                            super.setValueAt(comboData.indexOf(aValue), row, 1);
                        }
                    }
                }

            };
            JTable table = new JTable(model);
            table.setFillsViewportHeight(true);
            table.setGridColor(Color.GRAY);

            //popup menu to add row
            JPopupMenu popup = new JPopupMenu();
            JMenuItem newRow;
            newRow = new JMenuItem("New Row");
            newRow.setToolTipText("Add new row.");
            newRow.addActionListener((ActionEvent nr) -> {
                model.addRow(new Object[]{"", ""});
            });
            popup.add(newRow);

            table.setComponentPopupMenu(popup);

            comboData = new ArrayList<>(Arrays.asList(new String[]{"Zero", "One", "Two", "Three"}));

            JComboBox combo = new JComboBox(comboData.toArray(new String[comboData.size()]));
//          combo.addItemListener((ItemEvent e) -> {
//              if (e.getStateChange() == ItemEvent.SELECTED) {
//                  //sets value of cell to left of combobox to comboboxe's selected index
//                  System.out.println("Selected row = " + table.getSelectedRow());
//                  table.setValueAt(combo.getSelectedIndex(), table.getSelectedRow(), 1);
//              } else {
//                  //do nothing...
//              }
//          });

            DefaultCellEditor comboEditor = new DefaultCellEditor(combo);

            TableColumnModel tcm = table.getColumnModel();
            tcm.getColumn(0).setCellEditor(comboEditor);

            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(table));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
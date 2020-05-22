import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Test extends JFrame {

    private JTable table;
    private TableModel tableModel;

    public Test() {
        tableModel = new DefaultTableModel(5, 5);

        table = new JTable(tableModel);
        table.setColumnSelectionAllowed(true);

        getContentPane().add(table);

        Action handleEnter = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                table.getCellEditor().stopCellEditing(); // store user input
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                String val = String.valueOf(table.getValueAt(row, col)).toLowerCase();
                if (val.equals("u"))
                    --row;
                else if (val.equals("d"))
                    ++row;
                else if (val.equals("l"))
                    --col;
                else if (val.equals("r"))
                    ++col;
                if (     row >= 0 && row < tableModel.getRowCount()
                      && col >= 0 && col < tableModel.getColumnCount()) {
                    table.changeSelection(row, col, false, false);
                    table.editCellAt(row, col);
                }
            }
        };
        // replace action for ENTER, since next row would be selected automatically
        table.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "handleEnter");
        table.getActionMap().put("handleEnter", handleEnter);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setSize(800, 600);
        test.setVisible(true);
    }
}
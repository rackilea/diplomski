package snippet;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class JTableTest extends JFrame {

    public JTableTest() {
        super(JTableTest.class.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JTable table = new JTable(new Object[][] { { "1", "One" }, { "2", "Two" } }, new Object[] { "Column One", "Status" });
        addComboBoxToStatusColumn(table);
        add(new JScrollPane(table));
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
                new JTableTest().setVisible(true);
            }
        });
    }

    private void addComboBoxToStatusColumn(JTable table) {
        final int statusColumnIndex = table.getColumnModel().getColumnIndex("Status");

        TableColumn tmpColum = table.getColumnModel().getColumn(statusColumnIndex);
        final JComboBox comboBox = new JComboBox();
        loadRecordStatusFromDictionary(comboBox);

        DefaultCellEditor defaultCellEditor = new DefaultCellEditor(comboBox);
        tmpColum.setCellEditor(defaultCellEditor);
    }

    private void loadRecordStatusFromDictionary(JComboBox comboBox) {
        comboBox.addItem("Two");
        comboBox.addItem("Four");
        comboBox.addItem("Six");
    }
}
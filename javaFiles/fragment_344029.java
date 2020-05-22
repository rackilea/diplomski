import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTable;

public class TableTest extends JFrame {
JTable table;

public TableTest() {
    table = new JTable();
    this.add(table);
    //Adding table with four columns and rows
    table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String[]{
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
    ));
    //Adding table listener for Copy Ctrl+C
    addTableListener();
}

private void addTableListener() {
    table.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.isControlDown()) {
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    copy();
                }
            }
        }
    });
}

private void cancelEditing() {
    if (table.getCellEditor() != null) {
        table.getCellEditor().cancelCellEditing();
    }
}

public void copy() {
    cancelEditing();//To cancel editing if the cell is in edited mode
    int row = table.getSelectedRow();
    int col = table.getSelectedColumn();
    if (row != -1 && col != -1) {
        Object value = table.getValueAt(row, col);
        value = value != null ? value : "";
        StringSelection stringSelection = new StringSelection(value.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
    }
}

public static void main(String[] args) {
    TableTest test = new TableTest();
    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    test.pack();
    test.setLocationRelativeTo(null);
    test.setVisible(true);
}
}
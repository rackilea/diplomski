import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class TablePreferredSize {

    private String[] head = {"One", "Two", "Three", "Four", "Five", "Six"};
    private String[][] data = new String[25][6];
    private JTable table = new JTable(data, head);
    private DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
    private TableColumn column = new TableColumn();

    public TablePreferredSize() {
        table.setRowHeight(23);
        table.setIntercellSpacing(new Dimension(1, 1));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        column = new TableColumn();
        column.setModelIndex(0);
        column.setHeaderValue("apple");
        columnModel.addColumn(column);
        column = new TableColumn();
        column.setModelIndex(1);
        column.setHeaderValue("banana");
        columnModel.addColumn(column);
        column = new TableColumn();
        column.setModelIndex(2);
        column.setHeaderValue("pear");
        columnModel.addColumn(column);
        column = new TableColumn();
        column.setModelIndex(3);
        column.setHeaderValue("cherry");
        columnModel.addColumn(column);
        column = new TableColumn();
        column.setModelIndex(4);
        column.setHeaderValue("orange");
        columnModel.addColumn(column);
        column = new TableColumn();
        column.setModelIndex(5);
        column.setHeaderValue("lemon");
        columnModel.addColumn(column);
        table.setColumnModel(columnModel);
        //table.setPreferredScrollableViewportSize(new Dimension(rowWidth, 12 * rowHeight));
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Table PreferredSize");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TablePreferredSize t = new TablePreferredSize();
            }
        });
    }
}
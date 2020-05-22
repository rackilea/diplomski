import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Datagrid extends AbstractTableModel {
    private static final long serialVersionUID = -1080095595481949205L;
    private String[] title;
    private String[][] data;
    private JTable table;
    private JFrame frm;

    public Datagrid(String[] title, String[][] data) {
        this.title = title;
        this.data = data;

        create_table();
    }

    public static void main(String[] args) {
        String[] columnTitles = {"Title 1", "Title 2"};
        String[][] tableData = {{"Value 1", "Value 2"}, {"Another Value 1", "Another Value 2"}};
        new Datagrid(columnTitles, tableData);
    }

    public JTable getTable() {
        return table;
    }

    private void create_table() {
        table = new JTable(data, title);
        table.setModel(this);
        frm = new JFrame();
        frm.getContentPane().add(new JScrollPane(table));
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.pack();
        frm.setVisible(true);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public int getColumnCount() {
        return title.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }

    @Override
    public String getColumnName(int column) {
        return title[column];
    }

}
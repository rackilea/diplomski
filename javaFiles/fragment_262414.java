import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private String data;
    String[] columnTitle = { "AA","BB","CC","DD","EE" }; 

    public MyTableModel(String data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.length() / 5;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.charAt((rowIndex * 5) + columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnTitle[column];
    }
}
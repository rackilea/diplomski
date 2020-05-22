public class MyTableModel extends DefaultTableModel {

    public MyTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
            @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
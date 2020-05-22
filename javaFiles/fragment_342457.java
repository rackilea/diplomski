public class MyModel extends AbstractTableModel {

    private static final String[] columnNames = {"column 1", "column 2"};
    private final LinkedList<MyElement> list;

    private MyModel() {
        list = new LinkedList<MyElement>();
    }

    public void addElement(MyElement e) {
        // Adds the element in the last position in the list
        list.add(e);
        fireTableRowsInserted(list.size()-1, list.size()-1);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return list.get(rowIndex).getColumnOne();
            case 1: return list.get(rowIndex).getColumnOne();
        }
        return null;
    }

}
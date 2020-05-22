public class ColumnBasedTableModel extends AbstractTableModel {

    private Map<String, List<String>> columnData;
    private List<String> columnNames;

    public ColumnBasedTableModel() {
        columnData = new HashMap<>(25);
        columnNames = new ArrayList<>(25);
    }

    public void addColumn(String name, String... data) {
        columnNames.add(name);
        List<String> colData = columnData.get(name);
        if (colData == null) {
            colData = new ArrayList<>(26);
            columnData.put(name, colData);
        }
        colData.addAll(Arrays.asList(data));
    }

    @Override
    public int getRowCount() {
        int rows = 0;
        for (List<String> data : columnData.values()) {
            rows = Math.max(data.size(), rows);
        }
        return rows;
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        String name = getColumnName(columnIndex);
        List<String> data = columnData.get(name);
        if (data != null) {

            if (rowIndex < data.size()) {
                value = data.get(rowIndex);
            }

        }
        return value;
    }

}
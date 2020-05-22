public static void main(String[] args) {

    String[] headers = {"Name","Number"};
    String[][] rowData = {{"foo","500"},{"bar","700"}};
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();


    //frame.add(panel);
    //A table is controlled by its model, so we need a variable to access the model
    DefaultTableModel model = new DefaultTableModel(rowData,headers);
    JTable table = new JTable(model);
    JScrollPane scroll = new JScrollPane(table);
    //To allow sorting, we us a TableRowSorter object
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
    table.setRowSorter(sorter);

    //We have to set the 2nd column to be sortable
    ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
    //sorting on 2nd column (with index of 1), which is Number
    sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
    sorter.setSortKeys(sortKeys);
    sorter.sort();

    //add new value, then sort
    Object[] newRow = {"baz", "600"};
    model.addRow(newRow);
    sorter.sort();

    panel.add(scroll);
    frame.add(panel);
    frame.setSize(800, 400);
    //show is deprecrated.. I shouldn't be using it!
    frame.show();

    int minIndex = findMin(table, 1);
    //use the row index of the min item in column 1 to get the corresponding value in column 0
    System.out.println("Minimum String: " + table.getValueAt(minIndex, 0));

}

//find min value in the column with index tableColumnIndex and return the row index of that item
public static int findMin(JTable table, int tableColumnIndex) {

    int minIndex = 0;
    String min = table.getValueAt(0, tableColumnIndex).toString();
    for (int i = 1; i < table.getRowCount(); i++) {
        if (table.getValueAt(i, tableColumnIndex).toString().compareTo(min) < 0) {
            min = table.getValueAt(i, tableColumnIndex).toString();
            minIndex = i;
        }
    }
    return minIndex;
}
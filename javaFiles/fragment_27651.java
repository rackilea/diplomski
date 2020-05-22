public class NewClass1 extends JFrame {
    private JTable table;
    private DefaultTableModel defaultTableModel;
    private JScrollPane scrollPane;

    private class SelectionHelper implements ListSelectionListener, TableModelListener {
        private Object selectedRow;

        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) return;
            int selectedIndex = table.getSelectedRow();
            if (selectedIndex >= 0) {
                selectedRow = defaultTableModel.getDataVector().get(selectedIndex);
            } else {
                selectedRow = null;
            }
        }

        @Override
        public void tableChanged(TableModelEvent event) {
            if (selectedRow == null) return;
            int selectedIndex = defaultTableModel.getDataVector().indexOf(selectedRow);
            table.getSelectionModel().setSelectionInterval(selectedIndex, selectedIndex);
        }
    }

    public NewClass1() {
        // ...
        createTableModel();
        table = new JTable(defaultTableModel);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        SelectionHelper helper = new SelectionHelper();
        table.getModel().addTableModelListener(helper);
        table.getSelectionModel().addListSelectionListener(helper);
        // ...
    }
    // ...
}
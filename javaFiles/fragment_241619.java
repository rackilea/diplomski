public static void main(String[] args) {
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Selection", new Object[] { "A", "B", "C" });

    JTable table = new JTable(tableModel);
    ListSelectionModel selectionModel = table.getSelectionModel();

    JPanel p = new JPanel(new BorderLayout());
    p.add(table, BorderLayout.CENTER);

    int option = JOptionPane.showConfirmDialog(null, p, "Atomic Attacks", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE);

    if (JOptionPane.OK_OPTION == option) {
        printSelection(selectionModel, tableModel);
    } else {
        selectionModel.clearSelection();
    }

}

private static void printSelection(ListSelectionModel selectionModel, TableModel tableModel) {
    for (int i = selectionModel.getMinSelectionIndex(); i <= selectionModel.getMaxSelectionIndex(); i++) {
        if (selectionModel.isSelectedIndex(i)) {
            Object selectedValue = tableModel.getValueAt(i, 0);
            System.out.println(selectedValue);
        }
    }
}
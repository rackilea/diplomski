public void myMethod(JTable entryTable) {
    DefaultTableModel model = (DefaultTableModel) entryTable.getModel();
    if (entryTable.getRowCount() > 0) {
        if (entryTable.getSelectedRowCount() > 0) {
            int selectedRow[] = entryTable.getSelectedRows();
            for (int i : selectedRow) {
                int id = Integer.parseInt(entryTable.getValueAt(i, 0).toString());
                double val1 = Double.parseDouble(entryTable.getValueAt(i, 1).toString());
                double val2 = Double.parseDouble(entryTable.getValueAt(i, 2).toString());
                model.removeRow(i);
            }
        }
    }
}
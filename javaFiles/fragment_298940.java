@Override
public void actionPerformed(ActionEvent e) {
    int rowToDelete = 0;
    int rowToModel = 0;
    if (table.getSelectedRow() > -1) {
        rowToDelete = table.getSelectedRow();
        rowToModel = table.convertRowIndexToModel(rowToDelete);
        model.removeRow(rowToModel);
    }
}
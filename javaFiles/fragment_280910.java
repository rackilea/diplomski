String txt = jTextField1.getText();
for(int tableIndex = 0; tableIndex < ticketTable.getRowCount(); tableIndex++) {
    int rowModelId = ticketTable.convertRowIndexToModel(tableIndex);
    if(ticketTableModel.getValueAt(rowModelId,0).equals(txt) || ticketTableModel.getValueAt(rowModelId,1).equals(txt) {
        ticketTable.scrollRectToVisible(ticketTable.getCellRect(tableIndex,0));
        ticketTable.getSelectionModel().setSelectionInterval(tableIndex,tableIndex);
        break;
    }
}
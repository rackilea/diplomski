TableModel model = table.getModel();
for(int i = 0; i < model.getRowCount(); i++) {
    if((Boolean)model.getValueAt(i, 0)) {
        // delete the row
     }
}
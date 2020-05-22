int[] selectedRows = table.getSelectedRows();
if (selectedRows.length != 0) {
    for (int counter : selectedRows) {
        String value= table.getModel().getValueAt(counter, Constants.COLUMN).toString();
        /*
        * do stuff
        */
    }
}
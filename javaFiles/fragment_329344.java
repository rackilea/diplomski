private void addTableListener() {
    tableModel.addTableModelListener(new TableModelListener() {

        @Override
        public void tableChanged(TableModelEvent tme) {
            if (tme.getType() == TableModelEvent.UPDATE) {
               if (tme.getColumn()!=colDirty) { // colDirty = column no which I changed value programatically
                    tableModel.setValueAt(true, tme.getFirstRow(), colDirty);
               }
            }
        }
    });
}
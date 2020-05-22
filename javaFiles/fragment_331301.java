public MyTableModel extends AbstractTableModel() {
    // ...

    // modifies the value for the given cell
    @Override
    public void setValueAt(Object value, int row, int column) {
        Foo foo = this.list.get(row);
        if (column == INDEX_OF_ID_COLUMN) {
            foo.setId(value); // change the ID
            fireTableCellUpdated(row, column); // signal the the ID has changed
            // and now also change the description
            String newDescription = createNewDescription(value);
            foo.setDescription(newDescription);
            fireTableCellUpdated(row, INDEX_OF_DESCRIPTION_COLUMN); // signal the the description has changed  
        }
        // ...
    }
}
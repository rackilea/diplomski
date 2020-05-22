final JTable table = new JTable( data, columnNames ) {
    @Override
    public void changeSelection( int row, int col, boolean toggle, boolean expand ) {
        if( ( row + col )%2 == 0) { // here you set your own rules
            super.changeSelection( row, col, toggle, expand );
        }
    }

    @Override
    public boolean isCellEditable( int row, int col ) {
        return false; // disabling editing separately
    }
};
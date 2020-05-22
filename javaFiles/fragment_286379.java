// A default model with 5 rows and 6 columns
DefaultTableModel model = new DefaultTableModel(5, 6) {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 4:
            case 5: return Boolean.class; // Both 5th and 6th columns are booleans
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        /*
         * In order to know if 6th column is editable, you have to check
         * 5th column's value.
         */
        if(column == 5) {
            Object value = getValueAt(row, 4);
            return value != null && (Boolean)value;
        }
        return super.isCellEditable(row, column);
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        /*
         * If 5th column value is updated to FALSE, you need to 
         * set 6th column's value to FALSE as well
         */
        if(column == 4) {
            super.setValueAt(Boolean.FALSE, row, 5);
        } 
        super.setValueAt(aValue, row, column);
    }
};
final Class[] classes = new Class[]{Integer.class, Number.class};
DefaultTableModel model = new DefaultTableModel(0, 3) {

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex < classes.length) 
            return classes[columnIndex];
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return getColumnClass(column).getSimpleName();
    }

};
for (int row = 0; row < 15; row++) {
    model.addRow(new Object[]{row, row, row});
}
JTable table = new JTable(model);
table.setAutoCreateRowSorter(true);
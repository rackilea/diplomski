model = new DefaultTableModel(data, columns) {
    @Override
    public Class<?> getColumnClass(int column) {
        ...
    }
};
table = new JTable(model);
table.setModel(model);
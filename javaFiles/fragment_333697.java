TableModel model = new DefaultTableModel(data, new String[]{"One", "Two"}) {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 0 ? Double.class : String.class;
    }
};
table.setModel(model);
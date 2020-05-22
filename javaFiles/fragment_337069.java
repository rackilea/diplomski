DefaultTableModel model = new DefaultTableModel() {
    @Override
    Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
    }
};
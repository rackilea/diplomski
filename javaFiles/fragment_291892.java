DefaultTableModel model = new DefaultTableModel(0, 1) {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Float.class;
    }
};
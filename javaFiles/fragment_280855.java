DefaultTableModel model = new DefaultTableModel()  {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 0 ? Double.class 
                                : super.getColumnClass(columnIndex);
    }
};
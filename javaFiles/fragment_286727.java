jtable.setModel(new TableModel() {

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;   
    }
});
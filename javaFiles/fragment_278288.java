JTable table = new JTable() {
    @Override
    public boolean isCellEditable(int row, int column) {                
        return false;               
    };
};
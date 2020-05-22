JTable jtable1 = new JTable() {
    @Override
    public boolean isCellEditable(int row, int column) {
        // This is how we disable editing:
        return false;
    }
};
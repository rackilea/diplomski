public void setValueAt(int row, int col, Object value) {
    if (col != 4) {
        super.setValueAt(row, col, value);
        if (col == 2 || col == 3) {
            double amount = (Double)getValueAt(row, 2);
            double cost = (Double)getValueAt(row, 3);
            setValueAt(row, 4, amount - cost);
        }
    }
}
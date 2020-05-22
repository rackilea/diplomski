public Object getValueAt(int row, int col) {
    Object value = null;
    switch (col) {
        case 4:
            double amount = (Double)getValueAt(row, 2);
            double cost = (Double)getValueAt(row, 3);
            value = cost - amount;
            break;
    }
    return value;
}
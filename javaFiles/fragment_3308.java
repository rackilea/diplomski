@Override
public boolean isCellEditable(int row, int col) {
    if (col == 5)   // 0-indexed (6th col)
        return true;
    else if (col == 6) // 7th col
        return ((Boolean) getValueAt(row, 5)).booleanValue();
    else                // every other column
        return false; 
}
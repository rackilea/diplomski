for (int row = 0; row < table.getRowCount(); row++) {
    for (int col = 0; col < table.getColumnCount(); col++) {
        os.print(table.getColumnName(col));
        os.print(": ");
        os.println(table.getValueAt(row, col));
    }
}
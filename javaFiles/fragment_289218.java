@Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    RowData rowData = rows.get(rowIndex);
    switch (columnIndex) {
        case 1:
            if (aValue instanceof Float) {
                rowData.setStatus((float) aValue);
                fireTableCellUpdated(rowIndex, columnIndex);
            }
            break;
    }
}
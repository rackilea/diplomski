for (int colIdx = 0; colIdx < jTable.getColumnCount(); colIdx++)
{
    for (int rowIdx = 0; rowIdx < jTable.getRowCount(); rowIdx++)
    {
        TableColumnModel columnModel = jTable.getColumnModel();
        TableColumn column = columnModel.getColumn(colIdx);
        TableCellRenderer renderer = column.getCellRenderer();
        Object cellValue = jTable.getValueAt(rowIdx, colIdx);
        renderer.getTableCellRendererComponent(jTable, cellValue, 
                    false, false, rowIdx, colIdx);
    }
}
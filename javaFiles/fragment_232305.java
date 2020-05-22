rs=pst.executeQuery();
addDataToTable(tableSale,DbUtils.resultSetToTableModel(rs));
IDcombo.setSelectedItem(null);
Namecombo.setSelectedItem(null);

//ADD this method
public void addDataToTable(JTable table,TableModel model) {
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    DefaultTableModel resultSetModel = (DefaultTableModel) model;
    for (int i = 0; i < resultSetModel.getRowCount(); i++) {
        Vector row=new Vector();
        for (int j = 0; j < resultSetModel.getColumnCount(); j++) {
            row.addElement(resultSetModel.getValueAt(i, j));
        }
        tableModel.addRow(row);
    }
    tableModel.fireTableDataChanged();
}
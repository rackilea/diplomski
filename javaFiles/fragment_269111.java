DefaultTableModel model = (DefaultTableModel)table.getModel();
model.setRowCount(0);

for(Object o:content) 
{
    String[] rowData = presentAsStringArray(o);
    model.addRow( rowData );
}
DefaultTableModel model = (DefaultTableModel)table.getModel();
model.setRowCount(0);

while (rs.next()) 
{
    ...

    model.addRow(...);
}
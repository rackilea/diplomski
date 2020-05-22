//create TableModel
final Object columnNames[] = {"Link", "Status Code"};
DefaultTableModel listTableModel = new DefaultTableModel(columnNames,0);
//fill the TableModel
for (i = 0; i < links.size(); i++) {
    Object row[] = {links.get(i).getAttribute("href"), statusCode};
    listTableModel.addRow(row)
}
//associate the model with the table
resultTable.setModel(listTableModel);
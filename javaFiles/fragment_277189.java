System.out.println("searching");
tModel.setRowCount(0);// *********************remove current rows to replace
tModel.setColumnIdentifiers(columnNames);
while(r.next()){
    tModel.addRow(new Object[] { 
        r.getString("name")
    });
}
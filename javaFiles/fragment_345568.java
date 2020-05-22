listCustomers();         
DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
for(int i = 0; i < listCustomers.size(); i+=2){
    Object[] rowdata = new Object[] {listCustomers.get(i), listCustomers.get(i+1)};

    model.addRow(rowdata);
}
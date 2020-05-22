DefaultTableModel model = new DefaultTableModel(new Object[]{"name", "age", "address", "phone number"},0);
table = new JTable(model);

// Now when you populate the table, you would do this for example:
String[][] temp = cb.getData();
for (i=0; i<temp.length; i++){
    model.addRow(new Object[]{temp[i][0],temp[i][1],temp[i][2],temp[i][3]});
}
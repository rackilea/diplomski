DefaultTableModel defaultModel= (DefaultTableModel) tableToClear.getModel();
int rows = defaultModel.getRowCount();
while (rows > 0) {
       defaultModel.removeRow(0);
       rows = defaultModel.getRowCount(); // this is very important
}
String[] test = {"a", "b", "c"};
defaultModel.addRow(test);
public print(String total, TableModel tableModel)
{
  initComponents();
  this.ltotal = total;
  txtarea.setText(txtarea.getText() +"************************************\n");
  txtarea.setText(txtarea.getText() +"**********LOS Super*********\n");
  txtarea.setText(txtarea.getText() +"\n");
  txtarea.setText(txtarea.getText() +"Total............"  + ltotal + "\n");

  txtarea.setText(txtarea.getText() + "Product    Price\n");
  for (int i = 0; i < tableModel.getRowCount(); i++)
  {
    String product = (String) tableModel.getValueAt(i, 0);
    String price = (String) tableModel.getValueAt(i, 1);
    txtarea.setText(txtarea.getText() + product + "    " + price + "\n");
  }
}
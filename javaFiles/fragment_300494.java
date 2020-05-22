public String getTableData (JTable table) {
DefaultTableModel dtm = (DefaultTableModel) table.getModel();
int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
String tableData = " ";
for (int i = 0 ; i < nRow ; i++)
    for (int j = 0 ; j < nCol ; j++)
       // tableData = dtm.getValueAt(i,j);

String productid = table.getValueAt(i, j).toString();
                    String name = table.getValueAt(i, j).toString();
                    String quantity = table.getValueAt(i, j).toString();
                    String totalprice = table.getValueAt(i, j).toString();

                    try {

                        String query = "insert into sales (productid,customerid,name,quantity,discount,totalprice,paymentmethod) values (?,?,?,?,?,?,?)";
                        pst = con.prepareStatement(query);
                        pst.setString(1, productid);
                        pst.setString(2, customerid.getText());
                        pst.setString(3, name);
                        pst.setString(4, quantity);
                        pst.setString(5, discount.getText()+"%");
                        pst.setString(6, String.valueOf(totalprice));
                        pst.setString(7, paymethod.getSelectedItem().toString());
                        pst.execute();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                  }
return tableData;
    }
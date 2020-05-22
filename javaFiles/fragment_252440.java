try{

int rows=tblCO2.getRowCount();
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotams",user,pass);
conn.setAutoCommit(false);

String queryco = "Insert into tblcheckout(CheckoutID,ItemTagNo,ItemName,Category,Description,Location) values (?,?,?,?,?)";
pst = conn.prepareStatement(queryco);
for(int row = 0; row<rows; row++)
{
    String coitemname = (String)tblCO2.getValueAt(row, 0);
    String cocateg = (String)tblCO2.getValueAt(row, 1);
    String codesc = (String)tblCO2.getValueAt(row, 2);
    String coloc = (String)tblCO2.getValueAt(row, 3);
    String coitemtagno = (String)tblCO2.getValueAt(row, 4);
    pst.setString(1, coitemname);
    pst.setString(2, cocateg);
    pst.setString(3, codesc);
    pst.setString(4, coloc);
    pst.setString(5, coitemtagno);

    pst.addBatch();
}
pst.executeBatch();
conn.commit();
}
catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
}
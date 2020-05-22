String sql = "INSERT INTO customerdetails (FName, SName, Address, Postcode) VALUES (?, ?, ?,?)";
PreparedStatement pst = conn.prepareStatemtnt(sql);
pst.setString(1, newOrderTbl.getValueAt(insertRow, col2));
pst.setString(2, newOrderTbl.getValueAt(insertRow, col2+1));
pst.setString(3, newOrderTbl.getValueAt(insertRow, col2+2));
pst.setString(4, newOrderTbl.getValueAt(insertRow, col2+3));
pst.executeUpdate();
//rest of code...
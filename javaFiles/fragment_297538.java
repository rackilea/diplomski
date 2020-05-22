String query = " insert into Orders(Pro_Id ,Pro_Name,Order_Quantity,Order_Date,Order_Id)"
        + " values (?, ?, ?, ?, ?)";


  PreparedStatement Stmt = conn.prepareStatement(query);
  preparedStmt.setString (1, Pro_Id.getText());
  preparedStmt.setString (2, Order_Quantity());
  preparedStmt.setDate   (3, Order_Quantity.getText());
  preparedStmt.setBoolean(4, Order_Date.getText());
  preparedStmt.setInt    (5, Order_Id.getText());


 Stmt.execute();
String sql = "insert into Audittrail_tbl (Customer_ID, Payment)" +
            " select Name_ID, ?" +
              " from Customer_tbl" +
             " where FName = ?" +
               " and LName = ?";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, txtPayment.getText());
    stmt.setString(2, txtFName.getText());
    stmt.setString(3, txtLName.getText());
    stmt.executeUpdate();
}
String sql = "UPDATE STOCK\n"
            + "SET NUMBERINSTOCK = NUMBERINSTOCK - ? \n"
            + "WHERE UPPER(name) = ?";

    PreparedStatement statement = conn.prepareStatement(sql);
    int count = Integer.valueOf(RemoveTextField1.getText());
    statement.setInt(1, count);
    statement.setString(2, RemoveAnItemTextField.getText().toUpperCase());
try (PreparedStatement checkAccountExists = con.prepareStatement(
        "SELECT 1 FROM SAVINGS WHERE ACCOUNTNUMBER = ?")) {
    checkAccountExists.setInt(1, accountNumber);

    try (ResultSet rs = checkAccountExists.executeQuery()) {
        if (rs.next()) {
            // handle account already exists
        } else {
            try (PreparedStatement insert = con.prepareStatement(
                    "INSERT INTO SAVINGS(ID, ACCOUNTNUMBER, CUSTOMERNAME, BALANCE, MINMUM) VALUES (?, ?, ?, ? , ?)")) {
                insert.setInt(1, id);
                insert.setInt(2, accountNumber);
                insert.setString(3, customername);
                insert.setInt(4, balance);
                insert.setInt(5, minmum);

                insert.executeUpdate();
            }
        }
    }
}
public void deposit() throws SQLException {

    System.out.println("How much money do u want to deposit?");
    int val = sc.nextInt();
    int accountNumber = 654321;

    String query = "SELECT Balance FROM accounts.accs where AccountNumber = ?";
    try( Connection con = DriverManager.getConnection(url,username,password);
         PreparedStatement stmt = con.prepareStatement(query)) {

        stmt.setInt(1, accountNumber);
        ResultSet rs = stmt.executeQuery();

        String query2 = "UPDATE accs " +
                    "SET Balance = ? " +
                    "WHERE AccountNumber = ?";
        try (PreparedStatement stmt2 = con.prepareStatement(query2)) {
            while (rs.next()){
                int balance = rs.getInt("Balance");
                System.out.println("test");
                int updatedBalance = balance+val;
                System.out.println("the updatetbalance is" + updatedBalance +"");

                stmt2.setInt(1, updatedBalance);
                stmt2.setInt(2, accountNumber);
                stmt2.executeUpdate();
            }
        }
    }
}
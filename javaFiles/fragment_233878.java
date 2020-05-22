void f(int payment, int total, String name, String address, int contact, int creditCard) throws SQLException {
    if (payment >= total) {
        int change = payment - total;
        JOptionPane.showMessageDialog(null, "Thank you for shopping! Your change is " + change, "Exiting", JOptionPane.INFORMATION_MESSAGE);
        String URL = "jdbc:oracle:thin:@VAIO:49160:xe";
        String USER = "mariel";
        String PASS = "1234";

        // No longer needed in JDBC4: Class.forName("oracle.jdbc.driver.OracleDriver");
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            String sql2 = "INSERT INTO CUSTOMER "
                    + "VALUES(CustNumSeq.NEXTVAL, ?, ?, ?)";
            String generatedColumns[] = {"CUST_NUM"};
            try (PreparedStatement pstmt2 = conn.prepareStatement(sql2, generatedColumns)) {
                pstmt2.setString(1, name);
                pstmt2.setString(2, address);
                pstmt2.setInt(3, contact);
                pstmt2.executeUpdate();
                try (ResultSet rs = pstmt2.getGeneratedKeys()) {
                    if (rs.next()) {
                        int custNum = rs.getInt("CUST_NUM");

                        String sql = "INSERT INTO ORDERS "
                                + "VALUES(OrderNumSeq.NEXTVAL, ?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            for (int index = 0; index < add.itemNum.length; index++) {
                                pstmt.setInt(1, add.itemNum[index]);
                                pstmt.setInt(2, add.quantity[index]);

                                pstmt.executeUpdate();
                            }
                        }
                    }

                    String sql3 = "INSERT INTO TRANSACTION "
                            + "VALUES(TransNumSeq.NEXTVAL, ?, ?, ?, ?, ?)";
                    try (PreparedStatement pstmt3 = conn.prepareStatement(sql3)) {
                        pstmt3.setInt(1, custNum);
                        pstmt3.setInt(2, payment);
                        pstmt3.setString(3, payment_desc);
                        pstmt3.setInt(4, creditCard);
                        pstmt3.setInt(5, change);
                        pstmt3.executeUpdate();
                    }

                }
            }
        }
    }
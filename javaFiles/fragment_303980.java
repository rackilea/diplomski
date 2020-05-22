public void updateQuantity(String txtFieldValue,String id) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded!!!");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ooadp?useSSL=false", "root", "pass");
        System.out.println("Connection  created!!!");

        PreparedStatement pState;

        String sqlRawP1 ="select quantity from medicalproduct  where productID=?";//I guess medicalproduct is your table name
        pState = conn.prepareStatement(sqlRawP1);
        pState.setString(1, id);
        ResultSet rSetQuantity = pState.executeQuery();

        int countQuantity = 0;
        while(rSetQuantity.next()){
            countQuantity = rSetQuantity.getInt(1);//Am assumming that quantity is an integer
        }

        int value = Interger.parseInt(txtFieldValue);

        countQuantity-= value;

        String sqlRawP2 = "update medicalproduct set quantity=? where productID=?";
        pState = conn.prepareStatement(sqlRawP2);
        pState.setInt(1,countQuantity);
        pState.setString(2, id);

        pState.executeUpdate();

}
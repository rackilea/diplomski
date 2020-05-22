private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

   String text = jTextField1.getText();
   String combo =jComboBox1.getSelectedItem().toString();

    try {
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Michel's Muziek Magazijn.accdb");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mmm WHERE "+combo+" = '"+text+"'");

    while (rs.next()) {
            System.out.println("\t" + rs.getString(2) + "\t" + rs.getString(3)+ "\t" + rs.getString(4));
        }
        rs.close();

    } catch (SQLException e) {
        System.out.println(e);
    }

}
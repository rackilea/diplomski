public void actionPerformed(ActionEvent e) {
    String sql = "insert into spareparts (itemcode, partname, quantity, company, warranty," +
                                        " salesprice, purchaseprice, category, description)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "")) {
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, itemcodetf.getText().toString());
            stmt.setString(2, partnametf.getText().toString());
            stmt.setString(3, quantitytf.getText().toString());
            stmt.setString(4, companytf.getText().toString());
            stmt.setString(5, warrantytf.getText().toString());
            stmt.setString(6, salespricetf.getText().toString());
            stmt.setString(7, purchasepricetf.getText().toString());
            stmt.setString(8, categorytf.getText().toString());
            stmt.setString(9, descriptiontf.getText().toString());
            stmt.executeUpdate();
        }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(AddProductGUI.class.getName()).log(Level.SEVERE, null, ex);
    }   
}
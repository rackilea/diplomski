DefaultComboBoxModel model = new DefaultComboBoxModel();
try {        
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abpp034?user=abpp034&password=120001772");

    stmt = con.prepareStatement("SELECT Name FROM Discount WHERE Type = \"" + type + "\"");
    rs = stmt.executeQuery();

    while(rs.next()){
        model.addElement(rs.getString("Name"));
    }

} catch (SQLException ex) {
    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
} 
cbox.setModel(model);
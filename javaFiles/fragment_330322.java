public static void fillFirstNameCombobox() throws Exception{
    Class.forName("com.mysql.jdbc.Driver");

    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/crm", "root", "t00rt00r");
    PreparedStatement statement = (PreparedStatement) con.prepareStatement("SELECT `first_name` FROM `volunteers`");
    ResultSet result = statement.executeQuery();
    cbxCIFirstName.setToolTipText("Select a first name");
    cbxCIFirstName.setEditable(true);
    cbxCIFirstName.addItem("Please Select a first name");
    while(result.next()){
        cbxCILastName.addItem(result.getString(1)); 
    }
    System.out.println(result.getString(1));// this line can not be outside while loop
}
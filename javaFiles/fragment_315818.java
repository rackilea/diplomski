boolean check = true; // line 1
private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {
if (check){ // line 2
un = jTextField2.getText();
try{
    con = DriverManager.getConnection(path,"root","ashu");
    stat = con.createStatement();
    ResultSet rs = stat.executeQuery("SELECT * FROM login where username = '"+un+"'");
    while(rs.next()){
        if(rs.getString("username").equals(un)){
            jComboBox1.addItem(rs.getString("company"));
        }
    }
    rs.close();
    stat.close();
    con.close();
}
catch(Exception e){
    JOptionPane.showMessageDialog(this, "Database problem !", 
                                         "Error", 
                                          JOptionPane.ERROR_MESSAGE);
   }
  } // line 3

    check=false; // line 4
}
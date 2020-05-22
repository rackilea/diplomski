PreparedStatement ps = DeviceTracker.getConnection().prepareStatement("use SBK_CAPE_COOKIES SELECT * FROM \"CC_Employees\"" 
                                                                          +"WHERE EmployeeID LIKE ? AND FirstName LIKE ? AND Surname LIKE ? AND Email LIKE ? AND Region LIKE ? AND Department LIKE ?"
                                                                          ,ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
    if (!jTextField6.getText().isEmpty()) ps.setInt(1, Integer.parseInt(jTextField6.getText()));
    else ps.setString(1, "%"); 
    if (!jTextField5.getText().isEmpty()) ps.setString(2, jTextField5.getText());
    else ps.setString(2, "%"); 
    if (!jTextField4.getText().isEmpty()) ps.setString(3, jTextField4.getText());
    else ps.setString(3, "%"); 
    if (!jTextField3.getText().isEmpty()) ps.setString(4, jTextField3.getText());
    else ps.setString(4, "%"); 
    if(!jComboBox1.getSelectedItem().equals("All")) ps.setString(5, jComboBox1.getSelectedItem().toString());
    else ps.setString(5, "%"); 
    if(!jComboBox2.getSelectedItem().equals("All")) ps.setString(6, jComboBox2.getSelectedItem().toString());
    else ps.setString(6, "%"); 
    ResultSet rs = ps.executeQuery();
rs = sD.getSummonID(txtSummonID.getText());
if(condition to check that your id is null) {
   //display pop up
   JOptionPane.showMessageDialog(frame, "Id does not exists");
}else {
  // proceed further
  Summon s = null;
    try {
        while(rs.next())
        {s = new Summon(rs.getInt("id"), rs.getString("plateNum"), 
                rs.getDouble("amount"), rs.getString("recDate"), 
                rs.getString("location"), rs.getString("officer")); 
        }

          txtcarLicenceNo.setText(s.getCarLicenceNo());
          txtAmount.setText(Double.toString(s.getAmount()));
          txtLocation.setText(s.getLocation());
          txtOfficer.setText(s.getOfficerInCharge());                       
        }            
    catch (SQLException ex) 
    {
        System.err.println("SQL Exception: " + ex);
    }
}
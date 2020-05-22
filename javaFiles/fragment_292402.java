try
      {
          String sql = "UPDATE `master.Employees` SET `EmployeeName`=?, `Address `=?, `PhoneNumber`=?, `EmailAddress`=? WHERE `EmployeeID `=?";
         PreparedStatement ps = con.prepareStatement(sql);
         //putting value for all placeholder (?)
         ps.setString(1,jTextField2.getText());
         ps.setString(2,jTextField3.getText());
         ps.setInt(3,Integer.parseInt(jTextField4.getText()));
         ps.setString(4,jTextField5.getText());
         ps.setInt(5,Integer.parseInt(jTextField1.getText()));

         int i=0;
         i = ps.executeUpdate();
         if(i>0)
             {
         //do   something   
             }
     }
     catch(Exception e)
      {

      e.printStackTrace();

      }
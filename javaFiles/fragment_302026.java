for(int i = 0,j=1; i <= string_file_content.length; i++, j++)
   {
      if(Uname.equals(getdata[i]) && Psd.equals(getdata[j]))
          {
            JOptionPane.showMessageDialog(null, "Get the data for user and pass");
                        if(PMrole.equals(getdata[3]))
                        {
                            JOptionPane.showMessageDialog(null, "Login Successful");
                            Purchase_Manager_Access PMAccess = new Purchase_Manager_Access();
                            PMAccess.setVisible(true);
                            Username = User_txt.getText();
                        }

                        else if(SMrole.equals(getdata[3]))
                        {
                            Sales_Manager_Access SMAccess = new 
                            Sales_Manager_Access();
                            SMAccess.setVisible(true);
                            Username = User_txt.getText();

                         }
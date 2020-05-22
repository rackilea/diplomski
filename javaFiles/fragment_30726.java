if(txtName==null || txtName.getText()== null ||txtName.getText().trim().length()==0)
        {
            //must have name message
        }

        //Phone Number Validation
         if(txtPhoneNum==null || txtPhoneNum.getText()==null || txtPhoneNum.getText().length() < 10)
        {
            //Must atleast 10 characters
        }

         if(txtEmailAddr==null || txtEmailAddr.getText()== null ||
                 !(txtEmailAddr.getText().trim().contains("@") && txtEmailAddr.getText().trim().contains(".")))
        {
             //must have valid email address
         }
String str=user1.getText();

       if ("".equals(str)){  //User have not entered anything. 
        JOptionPane.showMessageDialog(null,"Please enter your name.");
        nameField.requestFocusInWindow();
        //Do NOT loop here.
    }
    else { 
        //Do everything you need to do when the user have entered something
    }
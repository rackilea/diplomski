fNameTextBoxResults.addActionListener(
    new ActionListener()
    {
       public void actionPerformed(ActionEvent e) 
       {
             //statement that checks to make sure user enters only letters
             if(fname.matches("[a-zA-Z]+"))
             {
                //updates 'Fname' field in db to text that user inputted in 'fname' textfield
                rs2.updateString("Fname", fname);
                JOptionPane.showMessageDialog(null, "Customer first name been updated!");
             }

             //statement that prompts user if they enter something other letters
             else
             {
                JOptionPane.showMessageDialog(null, "Please enter first name in correct format!");
                fNameTextBoxResults.setText("");
             }
       }
    });
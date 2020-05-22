public void actionPerformed(ActionEvent e){
           if(t1.getText().equals("Name") || t2.getText().equals("Section") || t3.getText().equals("Age")){
               JOptionPane.showMessageDialog(null, "Please fill in the incomplete fields");
            } else {
              //If the 'if statement' above is true, these code below will not execute
               t8.setText(t1.getText() + " of " + t2.getText() + " -- " + t3.getText() + " years old");
               t9.setText(t1.getText() + " of " + t2.getText() + " -- " + t3.getText() + " years old");
               t10.setText(t1.getText() + " of " + t2.getText() + " -- " + t3.getText() + " years old");
               t11.setText(t1.getText() + " of " + t2.getText() + " -- " + t3.getText() + " years old");
               t12.setText(t1.getText() + " of " + t2.getText() + " -- " + t3.getText() + " years old");
           }

        }
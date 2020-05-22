public String setOwnerName() {
  boolean isName = false;

while(!isName) {               
 ownerName = JOptionPane.showInputDialog(null, "Enter the account owner's name.",
               "Owner's Name", JOptionPane.PLAIN_MESSAGE);

  if(ownerName.trim().isEmpty()){
    JOptionPane.showMessageDialog(null,
        "Error you did not enter a name, please try again.", 
       "Error", JOptionPane.ERROR_MESSAGE);
  }
  else{
      isName = true;
      }               
   }// end of while

    return ownerName;
}
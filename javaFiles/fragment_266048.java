String name = jTextField3.getText();

    public boolean isNameValid(String name){
      if (name.length > 0){
          return true;
      } else {
         return false;
       }
    }

if (isNameValid(name)){
JOptionPane.showMessageDialog(this, "Name isn't valid");
}
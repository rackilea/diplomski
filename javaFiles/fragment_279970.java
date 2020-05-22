boolean found = false;

 // ...

    if (id.equals(split[0]))
        {
             JOptionPane.showMessageDialog(null, "ID already exists!", "Warning", 
             JOptionPane.WARNING_MESSAGE);
             found = true;
             //stop the while
             break;
        }

// ...

//check if id already exists or not. if not then add users info
if(!found){
      //put your adding users info code here
}
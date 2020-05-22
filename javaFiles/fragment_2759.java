public String getChar(){
    inChar = JOptionPane.showInputDialog("Please enter letter (a-z)");
    if (inChar != null) {
       if (inChar.length() > 1){
           JOptionPane.showMessageDialog(null, "Your Input is incorred, please input char", "Input warning", JOptionPane.WARNING_MESSAGE);
       }
     } else {
          inChar = ""
     }

    return inChar;
}
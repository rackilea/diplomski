try{
    int temp;
    temp = Integer.parseInt(c1.getText());
    if(temp < 0){
     JOptionPane.showMessageDialog(null,"negative values not allowed");
     return;
    }
}
catch(NumberFormatException ex){
     JOptionPane.showMessageDialog(null,"please fill the fields with proper values.");
     return;
}
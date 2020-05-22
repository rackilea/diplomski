try{
    number1=Double.parseDouble(text1);
    baseE=Double.parseDouble(text3);


    result =number1+basE;
    textfield3.setText(""+result);

}catch(NumberFormatException e){
    JOptionPane.showMessageDialog(null, "Enter Valid Numbers In TextField", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
}
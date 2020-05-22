try{
    Integer.parseInt(pin);
    try{
            Double.parseDouble(dep);
            t = true;
        }catch(NumberFormatException nfe1){
            l_message.setText("<html>Enter A Number In<br>Field: Deposit Amount</html>");
            t = false;
    }
}catch(NumberFormatException nfe){
    l_message.setText("Enter A Number In Field Pin");
    t = false;
}
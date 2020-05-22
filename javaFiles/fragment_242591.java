public void actionPerformed(ActionEvent e){
    String str = txtDecimal.getText();

    DecimalBinary b = new DecimalBinary();               
    b.setDecimal(str) // added
    lblBinary.setText(b.toString());

}//ends Action Performed
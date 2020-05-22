public void actionPerformed(ActionEvent ae){
    msg1 = ae.getActionCommand();
    if(msg1.equals("Submit")){
       msg2 = m.getText();     
       x = Integer.parseInt(msg2);
       y = x/100;
       msg = y + "";
       n.setText(msg);
  }
}
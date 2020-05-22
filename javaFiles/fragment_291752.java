private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    int a, b, c;
    if(jTextField1.getText().equals("")) {
        jLabel2.setText("Please enter a number");
    }
    else {
        a = Integer.parseInt(jTextField1.getText());
        b = Integer.parseInt(jTextField2.getText());
        c = a + b;
        jLabel2.setText("" + c);
    }
}
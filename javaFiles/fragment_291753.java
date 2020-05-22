private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    int a, b, c;

    try {
       a = Integer.parseInt(jTextField1.getText());
    } catch (NumberFormatException e) {
       jLabel2.setText("Please enter a number in field1");
       return;
    }

    try {
       b = Integer.parseInt(jTextField2.getText());
    } catch (NumberFormatException e) {
       jLabel2.setText("Please enter a number in field2");
       return;
    }

    c = a + b;
    jLabel2.setText("" + c);
}
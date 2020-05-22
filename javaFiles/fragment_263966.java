private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {                                     
    if (txtEmail.getText().equals("example@example.com")) {
        txtEmail.setText(null);
    }
}     


private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {                                   
   if ( txtEmail.getText().equals("")) {
        txtEmail.setText("example@example.com");
    }
}
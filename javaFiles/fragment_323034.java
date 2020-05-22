private void bConnectActionPerformed(ActionEvent evt) {                                   
    refresh.setEnabled(!refresh.isEnabled());
    refresh.setFocusPainted(refresh.isEnabled());
    if (refresh.isEnabled()) {
        refresh.requestFocus();
    }
    b2.setEnabled(!b2.isEnabled());
    b2.setFocusPainted(b2.isEnabled());
}
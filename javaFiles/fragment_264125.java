private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    int custID = 0;
    String custName = "";
    String custAddress = "";
    String custEmail = "";
    String custPhone = "";
    try {
        custID = Integer.parseInt(this.custIDField.getText());

        custName = this.nameField.getText();
        custAddress = this.addressField.getText();
        custEmail = this.emailField.getText();
        custPhone = this.phoneField.getText();
        comp.addCust(custID, custName, custAddress, custEmail, custPhone);
        custListArea.append(custID + ": " + custName);
        custListArea.append("\n");
        addressField.setText(null);
        emailField.setText(null);
        phoneField.setText(null);
        nameField.setText(null);
        custIDField.setText(null);
    } catch (NumberFormatException e) {
        errorMess.setText("Not a valid customer ID");
    }
}
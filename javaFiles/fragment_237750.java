private void updateTheTransaction(int id) {

   String tName = UpdateTransaction.txtTName.getText();
   String tID = UpdateTransaction.txtTID.getText();
   String tDetail = UpdateTransaction.txtTDetail.getText();
   String pName = UpdateTransaction.txtPName.getText();
   String pNRIC = UpdateTransaction.txtPNRIC.getText();
   String pDate = UpdateTransaction.txtPDate.getText();
   String pContact = UpdateTransaction.txtPContact.getText();
   String pEmail = UpdateTransaction.txtPEmail.getText();
   String pOrganisation = UpdateTransaction.txtPOrganisation.getText();

   Transaction updateTransaction = new Transaction(id+1, tName, tID, tDetail, pName, pNRIC, pDate, pContact, pEmail, pOrganisation);

   if (TransactionDA.updateTransaction(updateTransaction)) {
     JOptionPane.showMessageDialog(TransFrame, "Record successfully updated.");
   } else {
     JOptionPane.showMessageDialog(TransFrame, "Sorry, there seems to be an error in updating the record.");
   }
}
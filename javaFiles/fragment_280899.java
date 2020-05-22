private void displayComboBoxActionPerformed(java.awt.event.ActionEvent evt) { 
    if(displayComboBox.getSelectedIndex() > -1){
        int start = displayComboBox.getSelectedIndex() * 8;
        for (int x = start; x < start + 8; x ++) {
            firstNameTF.setText(personalList.get(x).toString());
        }
    }
}
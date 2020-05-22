private void addTabConfirmButtonActionPerformed(
        java.awt.event.ActionEvent evt) {

    tabPane.addTab(titleTextBox.getText(), new JLabel("This is my new tab"));
    tabPane.setSelectedIndex(tabPane.getTabCount() - 1);
    addTabDialog.setVisible(false);

}
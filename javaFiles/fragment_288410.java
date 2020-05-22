// caveat: code has not been tested by compilation or running. 
JButton myButton = new JButton(new AbstractAction("Show Dialog Button") {
  public void actionPerformed(ActionEvent evt) {
    MyDialogPanel myDialogPanel = new MyDialogPanel();
    JDialog myDialog = new JDialog(myJFrame, "My Dialog", 
            ModalityType.APPLICATION_MODAL);
    myDialog.add(myDialogPanel);
    myDialog.pack();
    myDialog.setLocationRelativeTo(myJFrame);
    myDialog.setVisible(true);

    // dialog now returns and we can get the data
    // assuming that the wrapper object for your data 
    // is called "DataObject"
    DataObject dataObject = myDialogPanel.getDataObject();

    // and perhaps use it. Assume setDataObject is a method 
    // of the main GUI that displays the data object
    setDataObject(dataObject);
  }
});
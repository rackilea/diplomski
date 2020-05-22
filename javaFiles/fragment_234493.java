MyDialog dialog = new MyDialog(null, true);  //true = modal
  //dialog.setModalityType(ModalityType.DOCUMENT_MODAL);  //or specify modal here
  dialog.setVisible(true);  //waits until dialog is closed
  if (dialog.wasAccepted()) {
    //grab values from dialog
    dialog.getCanvas();
  }
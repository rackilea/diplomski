public void done() {
  try {
    get(); // Will return null (as per Void type) but will also propagate exceptions.
  } catch(Exception ex) {
    JOptionPane.show ... // Show error in dialog.
  }
}
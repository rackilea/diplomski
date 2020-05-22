File fileChoice = fileChooser.showSaveDialog(root.getScene().getWindow());
if (fileChoice == null) {
  // handle cancellation properly
}
else {
  String path = fileChoice.getPath();
  ...
}
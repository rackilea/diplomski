JFileChooser chooser = new JFileChooser();
 if (targetFile != null) {
 chooser.setSelectedFile(targetFile);
 } else {
 chooser.setSelectedFile(newFile("default.xyz"));
 }
 int option = chooser.showSaveDialog(null);
 if (option == JFileChooser.APPROVE_OPTION) {
 targetFile = chooser.getSelectedFile();
 }
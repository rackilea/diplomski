FileDialog dlg = new FileDialog(frame, "Choose a file to copy", FileDialog.OPEN);
dlg.setVisible(true); // blocks until user completes the action
String fileToCopyString = dlg.getFile();

if (fileToCopyString != null) {
  File fileToCopy = new File(fileToCopyString);

  if (fileToCopy.isFile()) {
    FileUtils.copyFile(fileToCopy, new File(tmpDir, fileToCopy.getName());
  }
}
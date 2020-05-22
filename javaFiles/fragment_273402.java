JFileChooser chooser = new JFileChooser(path);
int result = chooser.showOpenDialog(mainFrame);
File file = chooser.getSelectedFile();
if (result == JFileChooser.APPROVE_OPTION && file != null && file.exists()) {
  mainFrame.setImageFile(file);
}
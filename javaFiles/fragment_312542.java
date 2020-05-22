JFileChooser fc = new JFileChooser();
fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

fc.setDialogTitle("Select a folder");
fc.setApproveButtonText(SELECT);
if(fc.showOpenDialog(singleton) == JFileChooser.APPROVE_OPTION) {
  File folder = fc.getSelectedFile();
  String path = folder.getPath() + File.separatorChar + "MYAPPFOLDER";
}
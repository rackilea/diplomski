fileChooser.addPropertyChangeListener(JFileChooser.FILE_FILTER_CHANGED_PROPERTY, new PropertyChangeListener()
{
  public void propertyChange(PropertyChangeEvent evt)
  {
    FileFilter filter = (FileFilter)evt.getNewValue();

    String extension = getExtensionForFilter(filter); //write this method or some equivalent

    File selectedFile = fileChooser.getSelectedFile();
    String path = selectedFile.getAbsolutePath();
    path.substring(0, path.lastIndexOf("."));

    fileChooser.setSelectedFile(new File(path + extension));
  }
});
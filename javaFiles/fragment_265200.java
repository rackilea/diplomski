if (result == JFileChooser.APPROVE_OPTION)
{
  File file = fileChooser.getSelectedFile();
  String path = file.getAbsolutePath();

  String extension = getExtensionForFilter(fileChooser.getFileFilter());

  if(!path.endsWith(extension))
  {
    file = new File(path + extension);
  }
}
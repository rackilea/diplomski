FileDialog dlg = ...
String filename = dlg.open();
if (filename != null) {
  File file = new File(filename);
  readXML(file);
}
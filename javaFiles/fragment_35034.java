File file = chooser.getSelectedFile();
if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("xml")) {
    // filename is OK as-is
} else {
    file = new File(file.toString() + ".xml");  // append .xml if "foo.jpg.xml" is OK
    file = new File(file.getParentFile(), FilenameUtils.getBaseName(file.getName())+".xml"); // ALTERNATIVELY: remove the extension (if any) and replace it with ".xml"
}
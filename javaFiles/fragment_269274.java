Preferences p = Preferences.userNodeForPackage(TestFileChooser.class);
String listOfFiles = p.get("RectentFileList.fileList", null);
if (listOfFiles != null) {
    String[] files = listOfFiles.split(File.pathSeparator);
    for (String fileRef : files) {
        File file = new File(fileRef);
        if (file.exists()) {
            add(file);
        }
    }
}
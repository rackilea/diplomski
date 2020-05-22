StringBuilder sb = new StringBuilder(128);
for (int index = 0; index < listModel.getSize(); index++) {
    File file = listModel.getElementAt(index);
    if (sb.length() > 0) {
        sb.append(File.pathSeparator);
    }
    sb.append(file.getPath());
}
System.out.println(sb.toString());
Preferences p = Preferences.userNodeForPackage(TestFileChooser.class);
p.put("RectentFileList.fileList", sb.toString());
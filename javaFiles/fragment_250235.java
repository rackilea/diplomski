File folder = new File("/path/to/files");
File[] listOfFiles = folder.listFiles();

for (int i = 0; i < listOfFiles.length; i++) {
  File file = listOfFiles[i];
  if (file.isFile() && file.getName().endsWith(".txt")) {
    String content = FileUtils.readFileToString(file);
    /* do somthing with content */
  } 
}
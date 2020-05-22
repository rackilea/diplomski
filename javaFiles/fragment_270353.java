HashMap<String,String> fileNamevsPathMap = new HashMap<String,String>();
String rootDirectory = "Your Directory Path to Search";
boolean isRecursive = true;
Collection files = FileUtils.listFiles(rootDirectory, null, isRecursive);
for (Iterator iterator = files.iterator(); iterator.hasNext();) {
    File file = (File) iterator.next();
    fileNamevsPathMap .put(file.getName(),file.getAbsolutePath()
}
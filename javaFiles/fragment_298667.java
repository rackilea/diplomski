String filePath = ze.getName();
fileName = filePath.substring(fileName.lastIndexOf("/") + 1);
folderPath = filePath.substring(0, fileName.lastIndexOf("/"));
File folder = new File(destinationFolder + folderPath)
if (!folder.exists()) {
    folder.mkdir();
}
File file = new File(folder, fileName);
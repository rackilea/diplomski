String fileName = FilenameUtils.getName(fileItem.getName());
String fileNamePrefix = FilenameUtils.getBaseName(fileName) + "_";
String fileNameSuffix = "." + FilenameUtils.getExtension(fileName);
File file = File.createTempFile(fileNamePrefix, fileNameSuffix, uploadFolder);
fileItem.write(file);
System.out.println("File successfully saved as " + file.getAbsolutePath());
// ...
Path folder = Paths.get(System.getProperty("upload.location"));
String filename = FilenameUtils.getBaseName(uploadedFile.getName()); 
String extension = FilenameUtils.getExtension(uploadedFile.getName());
Path file = Files.createTempFile(folder, filename + "-", "." + extension);

try (InputStream input = uploadedFile.getInputStream()) {
    Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
}

String uploadedFileName = file.getFileName().toString();
// Now store it in DB.
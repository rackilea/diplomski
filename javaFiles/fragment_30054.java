String prefix = FilenameUtils.getBaseName(uploadedFile.getName()); 
String suffix = FilenameUtils.getExtension(uploadedFile.getName());
File uploadLocation = new File("/path/to/uploads"); // Make it configureable!
File file = File.createTempFile(prefix + "-", "." + suffix, uploadLocation);

InputStream input = uploadedFile.getInputStream();
OutputStream output = new FileOutputStream(file);

try {
    IOUtils.copy(input, output);
} finally {
    IOUtils.closeQuietly(output);
    IOUtils.closeQuietly(input);
}
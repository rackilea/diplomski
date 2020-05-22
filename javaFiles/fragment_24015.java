// Extract the original filename from the filepath.
Page page2 = element.click();
String filepath = page2.getUrl().getFile();
String filename = FilenameUtils.getName(filepath);
System.out.println(filename);

// Download the file.
InputStream inputStream = page2.getWebResponse().getContentAsStream();
FileOutputStream outputStream = new FileOutputStream(filename);
int read;
byte[] bytes = new byte[1024];
while ((read = inputStream.read(bytes)) != -1) {
    outputStream.write(bytes, 0, read);
}
String fileName = tvtitle.getText().toString();
String fileExtension = tvtype.getText().toString();
File imageDirectory = new File(Path);
FileInputStream fis = new FileInputStream(imageDirectory);
ZipEntry zipEntry = new ZipEntry(fileName);

FileOutputStream fos = new FileOutputStream("test.zip");
ZipOutputStream zos = new ZipOutputStream(fos);
zos.putNextEntry(zipEntry);
byte[] bytes = new byte[1024];
int length;
    while ((length = fis.read(bytes)) >= 0) {
        zos.write(bytes, 0, length);
    }
zos.closeEntry();
fis.close();
zos.close();
fos.close();
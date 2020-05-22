ZipOutputStream targetStream = new ZipOutputStream(fileToSaveTo);
ZipEntry entry = new ZipEntry(nameOfFileInZipFile);
targetStream.putNextEntry(entry);

byte[] dataBlock = new byte[1024];
int count = inputStream.read(dataBlock, 0, 1024);
while (count != -1) {
    targetStream.write(dataBlock, 0, count);
    count = inputStream.read(dataBlock, 0, 1024);
}
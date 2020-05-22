ZipInputStream zipStream = new ZipInputStream(new ByteArrayInputStream(bytes));
ZipEntry entry = null;
while ((entry = zipStream.getNextEntry()) != null) {

    String entryName = entry.getName();

    FileOutputStream out = new FileOutputStream(entryName);

    byte[] byteBuff = new byte[4096];
    int bytesRead = 0;
    while ((bytesRead = zipStream.read(byteBuff)) != -1)
    {
        out.write(byteBuff, 0, bytesRead);
    }

    out.close();
    zipStream.closeEntry();
}
zipStream.close();
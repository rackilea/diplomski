InputStream is = new FileInputStream(FILE NAME);
ZipInputStream zis = new ZipInputStream(is);
zis.getNextEntry();
byte[] bytes = new byte[2];
zis.read(bytes, 0, 2);
zis.close();
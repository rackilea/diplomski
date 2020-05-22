InputStream in = ...
ZipInputStream zipIn = new ZipInputStream(in);

ZipEntry entry;
while ((entry = zipIn.getNextEntry()) != null) {
     // handle the entry
}
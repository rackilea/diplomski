ZipOutputStream zs = null;
try {
  zs = new ZipOutputStream(os); // Where os is your ByteArrayOutputStream 
  ZipEntry e = new ZipEntry(fileName); // fileName is your file (in the zip)
  zs.putNextEntry(e);
  zs.write(theContent); // theContent is the the file content.
} finally {
  if (zs != null) {
    zs.close();
  }
}
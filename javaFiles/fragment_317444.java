ZipEntry entry = zipStream.getNextEntry();
while (entry != null) {
  if (!entry.isDirectory()) {
    String filename = entry.getName();//this includes the path!
    byte[] data = ByteStreams.toByteArray(zipStream);
    //do something with the bytes 
  }
  entry = zipIn.getNextEntry();
}
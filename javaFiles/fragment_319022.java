public void usingFileOutputStream() 
  throws IOException {
    String str = "Hello";
    FileOutputStream outputStream = new FileOutputStream(fileName);
    byte[] strToBytes = str.getBytes();
    outputStream.write(strToBytes);

    outputStream.close();
}
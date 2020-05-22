public static void readFile(String filename) {
  ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
  try {
    FileInputStream fis = new FileInputStream(filename);
    byte b=0;
    while((b=fis.read())!=-1) {
        outputStream.write(b);
    }
    byte[] byteData=outputStream.toByteArray();
    fis.close();
  }
  catch(IOException ioe) {
    System.out.println("IOException: " + ioe);
}
for(File file : rtfTemplateList){
try {
    fileInputStream = new FileInputStream(file);
byte[] byteArray = new byte[(int) file.length()];
fileInputStream.read(byteArray);
ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
etc...
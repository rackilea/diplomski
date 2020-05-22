File file = new File(imagePath);
log("File size: " + file.length());
byte[] result = null;
try {
  InputStream input =  new BufferedInputStream(new FileInputStream(file));
  result = readAndClose(input);
}
catch (FileNotFoundException ex){
  log(ex);
}
BASE64Encoder encoder = new BASE64Encoder();    
imageString = encoder.encode(result);
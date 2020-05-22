byte[] readAndClose(InputStream aInput){
  byte[] bucket = new byte[32*1024]; 
  ByteArrayOutputStream result = null; 
  try  {
    try {
      result = new ByteArrayOutputStream(bucket.length);
      int bytesRead = 0;
      while(bytesRead != -1){
        bytesRead = aInput.read(bucket);
        if(bytesRead > 0){
          result.write(bucket, 0, bytesRead);
        }
      }
    }
    finally {
      aInput.close();
    }
  }
  catch (IOException ex){
    log(ex);
  }
  return result.toByteArray();
}
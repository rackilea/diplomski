public static String compress(byte[] data) throws IOException {  
   Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION,true);
   deflater.setInput(data);    
   ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);   
   deflater.finish();  
   byte[] buffer = new byte[1024];   
   while (!deflater.finished()) {  
    int count = deflater.deflate(buffer); // returns the generated code... index  
    outputStream.write(buffer, 0, count);   
   }  
   outputStream.close();  
   byte[] output = outputStream.toByteArray();      
   return new String(Base64.getEncoder().encode(output));  
  }
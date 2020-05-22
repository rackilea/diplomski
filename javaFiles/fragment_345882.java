public static String read() throws IOException {
   String readtext;    
   byte[] buff = new byte[1024];    
   int read;

   if((read = telnetClient.getInputStream().read(buff)) > 0) {    
       readtext = new String(buff, 0, read);
   }
    return readtext;    
   }
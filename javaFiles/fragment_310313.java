public void load(String fname) throws Exception {
   // try opening file    
   File file = new File(fname);
   // check if valid file
   if( !file.exists() ){
      // if no valid file throw exception so we can react on that
      throw new Exception("File not available: "+fname);
   }
   //your code for reading here, at this point you know the file exists
   //...
}
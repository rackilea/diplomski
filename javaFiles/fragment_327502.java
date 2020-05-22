BufferedInputStream  input;
 BufferedOutputStream output;

........

   try{
       .........
  ............

    BufferedInputStream  input = new BufferedInputStream
     (new ByteArrayInputStream(sImageBytes));
        BufferedOutputStream output =
       new BufferedOutputStream(response.getOutputStream());

      int length;
      length = sImageBytes.length;    
      output.write(sImageBytes, 0, length);
    catch(Exception ex){
         System.out.println("error :"+ex);
    } finally{
    if(output != null) {
       output.flush();
       output.close();
    }
    if(input != null) {
       input.close();
    }
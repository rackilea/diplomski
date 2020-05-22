InputStream stream = null;
try {
   // IO stuff - create the stream and manipulate it
} catch (IOException ex){
  // handle exception
} finally {
  try {
     stream.close();
  } catch (IOException ex){}
}
try{
  File f1 = new File("path to file"); 
  boolean success=f1.delete();
  if(!success){
    // Notify user that the file 
  }
}catch(SecurityException ex){
 // No sufficient rights to do this operation
}
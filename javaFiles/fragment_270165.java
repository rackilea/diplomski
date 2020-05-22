public void functionC() throws Exception{
  try{
    throw new Exception("This exception doesn't know where to go.");
  }catch(Exception e){
    System.err.println("Exception caught: "+e);
  }
}
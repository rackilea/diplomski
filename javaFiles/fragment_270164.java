public void functionB(){
  try{
    throw new Exception("This exception is handled here.");
  }catch(Exception e){
    System.err.println("Exception caught: "+e);
  }
}
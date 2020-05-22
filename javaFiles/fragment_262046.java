try{
   method();
}
catch(Exception e){
   e.getStackTrace()[0].getLineNumber();
   e.getStackTrace()[0].getFileName();
   e.getStackTrace()[0].getMethodName();
}
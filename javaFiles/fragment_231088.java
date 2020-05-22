String fileName = null;
try{
   fileName = buildFileName();
}
catch(Exception e){
   ...
   System.exit(1);
}
FILE_NAME = fileName;
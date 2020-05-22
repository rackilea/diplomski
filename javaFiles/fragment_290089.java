File folder = new File(Environment.getExternalStorageDirectory() + "/"+ "NewFolder");
 folder.mkdir();
boolean success = true;
  if (folder.exists()) 
  {
     success=true;
   else{
       success=false;
       folder.mkdirs();
      }
File new_file =new File(directory.getAbsolutePath() + File.separator +  "new_file.png");
try
  {
   new_file.createNewFile();
  }
  catch (IOException e)
  {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
Log.d("Create File", "File exists?"+new_file.exists());
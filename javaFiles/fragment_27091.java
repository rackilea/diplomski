private static File getOutputMediaFile() { 
   ...
   ...
   //create file on disk
   if(!mediaFile.exists()) mediaFile.createNewFile();

   return mediaFile;
}
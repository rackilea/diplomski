File[] files = dir.listFiles();
for(File file : files){
   if (file.isDirectory ()) continue;

   ....
}
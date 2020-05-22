File[] files = new File(<directory>).listFiles();
for(File file : files){
  if(file.getAbsolutePath().endsWith(".jpg")){
      //perform delete
  }
}
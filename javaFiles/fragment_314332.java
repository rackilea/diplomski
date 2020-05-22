for(String fileNameStr: filesList){
  File file = new File(fileNameStr);
  String dir = file.getParent().substring(file.getParent().lastIndexOf(File.separator) + 1);//page01
  String fileName = f.getName();
  if(fileName.indexOf(".")!=-1){
     fileName = fileName.substring(0,fileName.lastIndexOf("."));
   }
}
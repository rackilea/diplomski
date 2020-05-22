if(current.isDirectory()){
  System.out.println("Directory: " + file.getName());
  //Get list of files by file.listFiles() and pass it to 
 // to other method that will do processing. 
  digest = this.encodeUTF8(current.getName());
  md5.update(digest);
}
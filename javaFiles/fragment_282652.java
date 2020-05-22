try{
  //call the getPath uri with context and uri
  //To get path from uri
  String path = getPath(this, uri);
  File file = new File(path);
  String filename = file.getName();
  Log.e(TAG, "File Name: " + filename);
}catch(Exception e){
   e("Err", e.toString()+"");
}
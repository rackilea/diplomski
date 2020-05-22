onCreate(Bundle svaeInstance){
 ........
 ........
  if(findSongs("/storage/sdcard1/")!=null){
    ArrayList<String> listOfFilePath=findSongs("/storage/sdcard1/"); // here you will get all the files path which contains .mp3 at the end.
 //do the remaining stuff
  }else { Toast.makeText(this, "sdCard not available", Toast.LENGTH_SHORT).show();
  }
 ......
}
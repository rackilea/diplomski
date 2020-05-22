String sep = File.separator; // Use this instead of hardcoding the "/"
String newFolder = "FolderName";
String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
File myNewFolder = new File(extStorageDirectory + sep + newFolder);
myNewFolder.mkdir();
mediaFile = Environment.getExternalStorageDirectory().toString() 
  + sep + newFolder + sep + "myRecordings.mp3";
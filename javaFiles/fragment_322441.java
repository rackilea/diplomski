String file = "file:///path/of/your/file";
String remote = "https://www.example.com/your_video.mp4";

File fileFile = new File(file);
File remoteFile = new File(remote);

Log.d("File", "" + fileFile.exists()); // prints true if the file exists
Log.d("File", "" + remoteFile.exists()); // prints false always
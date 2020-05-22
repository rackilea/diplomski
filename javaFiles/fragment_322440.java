String file = "file:///path/of/your/file";
String remote = "https://www.example.com/your_video.mp4";

Uri fileUri = Uri.parse(file);
Uri remoteUri = Uri.parse(remote);

String fileScheme = fileUri.getScheme();
String remoteScheme = remoteUri.getScheme();

Log.d("Scheme", fileScheme); // prints file
Log.d("Scheme", remoteScheme); // prints https
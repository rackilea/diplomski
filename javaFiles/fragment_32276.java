String TAG = "MyApp"
 File file = new File("/your_directory");  
 File[] files = file.listFiles();  
 for (int fileInList = 0; fileInList < files.length; fileInList++)  
 {  
     Log.i(TAG, files[fileInList].toString());  
 }
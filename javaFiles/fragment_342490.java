File sdcard = Environment.getExternalStorageDirectory();
File file = new File(sdcard, "path/to/the/file");
BufferedReader br = new BufferedReader(new FileReader(file));
String line;
while ((line = br.readLine()) != null) {       
    String[] split = line.split(","); 
    for(int i = 0; i < split.length; i++) {
      Log.d(TAG, "value " + i + ": " + split[i]);
    }
}
br.close();
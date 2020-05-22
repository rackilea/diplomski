String SDCardRoot = Environment.getExternalStorageDirectory().toString();
String filename = "fileName" + ".jpg";
File myDir = new File(SDCardRoot + "/AppName");
myDir.mkdirs();
File file = new File(myDir, filename);
FileOutputStream fileOutput = new FileOutputStream(file);

//write the file into the sdcard folder specify your buffer , bufferLength 

fileOutput.write(buffer, 0, bufferLength);
fileOutput.close();
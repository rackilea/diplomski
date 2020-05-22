//create local file
File localFile = new File(outDir, FILE_NAME));
// get file size if the file exists
long localFileSize = localFile.length();   
//retrieve file from server
try {
  OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localFile, true));
  byte[] bytesArray = new byte[4096];
  int bytesRead;
  int totalRead = (int) localFileSize;
  ftpClient.restart(localFileSize);
  InputStream inputStream = ftpClient.retrieveFileStream(REMOTE_FILE);

  while ((bytesRead = inputStream.read(bytesArray)) != -1) {
     totalRead += bytesRead;
     outputStream.write(bytesArray, 0, bytesRead);
  // break the loop when AsyncTask is cancelled
     if(isCancelled()){
        break;
     }
  }
  if (ftpClient.completePendingCommand()) {
     // Task completed!
  }

  inputStream.close();
  outputStream.close();
} catch (IOException e) {
   e.printStackTrace();
}
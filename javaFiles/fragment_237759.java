int filesToRead = in.readInt();    
for(int i = 0; i < filesToRead; i++){
  String path = in.readUTF();
  long bytesToRead = in.readLong();      
  FileOutputSteam fos = new FileOutputStream(path);

  byte[] buffer = new byte[1024];
  while(bytesToRead > 0){
    bytesRead = in.read(buffer,0,bytesToRead > buffer.length ? buffer.length : bytesToRead);
    bytesToRead -= bytesRead;
    fos.write(buffer);
  }
}
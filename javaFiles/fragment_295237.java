int bytesRead = 0;
 while((count = dis.read(buffer)) > 0 && bytesRead != fileSizeFromClient){
  bytesRead += count; 
  bos.write(buffer, 0, count);
 }
 bos.close();
 //don't close the input stream
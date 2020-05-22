byte[] buffer = new byte[BUFFER_SIZE];

int bytesRead = 0;
while ((bytesRead = in.read(buffer)) >= 0){
  for (int i = 0; i < bytesRead; i++){
     //Do whatever you need with the bytes here
  }
}
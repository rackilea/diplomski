BufferedInputStream input = new BufferedInputSream(socket.getInputStream());
byte[] buffer = new byte[10]; // 10 bytes buffer
int bytesRead = 0;
while( (bytesRead=input.read(buffer)) !=-1 ) { // read up to 10 bytes
    String str = new String(buffer,0,bytesRead); // convert bytes to String using default encoding
    System.out.println("Data received: " + str);
}
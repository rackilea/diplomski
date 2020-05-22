// code at receiver side
byte buffer[] = new byte[80];
int bytes_read = inputStream.read( buffer );
String received = new String(buffer, 0, bytes_read);
try{Thread.sleep(100);} catch(InterruptedException e){}
int receiveLines = Integer.parseInt(received);

PrintWriter out = new PrintWriter(new FileOutputStream("received.txt"));

for(int i=0; i<receiveLines; i++) {
  bytes_read = inputStream.read( buffer );
  received = new String(buffer, 0, bytes_read);
  out.println(received);    
  Thread.sleep(100);
}
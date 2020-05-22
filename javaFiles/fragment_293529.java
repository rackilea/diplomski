BufferedOutputStream bos = new BufferedOutputStream(System.out);

byte[] message="Hello from java TCP Server!".getBytes();

bos.write("HTTP/1.1 200 OK\r\n".getBytes());
bos.write("Content-Type: text/plain\r\n".getBytes());
bos.write(("Content-Length: "+message.length+"\r\n").getBytes());
bos.write("\r\n".getBytes()); // empty line between HTTP header and HTTP content
bos.write(message);
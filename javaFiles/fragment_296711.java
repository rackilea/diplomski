int filePosition = 0;

InputStream is = clientSocket.getInputStream();
ByteArrayOutputStream baos = new ByteArrayOutputStream();

do {
    baos.write(mybytearray);
    bytesRead = is.read(mybytearray);

    if(bytesRead != -1)
        filePosition += bytesRead;
}
while (bytesRead != -1);
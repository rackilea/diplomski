while((bytesRead = inStream.read(buffer)) > 0){

    outStream.write(buffer, 0 , bytesRead);           
    buffer = new byte[100000]; // this line is useless
    totalBytesRead += bytesRead;
}
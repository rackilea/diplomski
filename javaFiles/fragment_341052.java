1 while (true) {
 2   int nBytesRead = src.read(buff);
 3   if (nBytesRead < 0) {
 4     break;
 5   }
 6   byteStream.write(buff);
 7 }
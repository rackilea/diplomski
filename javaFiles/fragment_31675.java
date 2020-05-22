for(int i=0; i<=(normalText.length/blockSize); i++) {
     int offset = i*blockSize;
     //To handle last block of bytes in input
     int len = Math.min(blockSize,normalText.length-offset);
     bytesProcessed += mode.processBytes(normalText,offset,len,encryptedText,bytesProcessed);
}
mode.doFinal(encryptedText, bytesProcessed);
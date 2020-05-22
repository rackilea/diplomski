while(sizeOfFile + byteLength < desiredSizeOfFile)
     {           
     fc.write(b);
     b.rewind();
     sizeOfFile += byteLength;       
     }
     int diff = (int) (desiredSizeOfFile - sizeOfFile);
     sizeOfFile += diff;

     ByteBuffer d = ByteBuffer.allocate(diff);

     fc.write(d);
     b.rewind();

     fos.close();
     System.out.println("Finished at " + sizeOfFile / 1073741824  + " Gigabyte(s)");                
 }
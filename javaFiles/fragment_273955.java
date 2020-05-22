int theNumber = 237;
   byte[] buf = new byte[4];
   for( int i = 0; i < 4; i++ ){
   buf[3 - i] = (byte)(theNumber & 0xFF);
       theNumber = theNumber >> 8;
   }
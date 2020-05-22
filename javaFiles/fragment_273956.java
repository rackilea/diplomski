int theNumber = 237;
   byte[] buf = new byte[4];
   for( int i = 0; i < 4; i++ ){
   buf[3 - i] = (byte)(theNumber % 10 + 0x30);
       theNumber = theNumber / 10;
   }
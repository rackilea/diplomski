public static void main( String[] args )
           throws Exception
   {
      byte[] str = new byte[ 17 ];

      str[0] = 115; //s
      str[1] = 121; //y
      str[2] = 112; //p
      str[3] = 105; //i
      str[4] = 49; //current UnixTime numbers
      str[5] = 52;
      str[6] = 49;
      str[7] = 50;
      str[8] = 49;
      str[9] = 49;
      str[10] = 51;
      str[11] = 51;
      str[12] = 50;
      str[13] = 57;
      str[14] = 52;
      str[15] = 49;
      str[16] = 50;

      String test = new String( str, "UTF-8" );
      System.out.println( test );

      ByteBuffer buf = ByteBuffer.wrap( str );

      Charset ch = Charset.forName( "UTF-8" );
      CharsetDecoder cd = ch.newDecoder();
      CharBuffer cbuf = CharBuffer.allocate( 1024 );
      CoderResult cr = cd.decode( buf, cbuf, true );
      System.out.println("\"?"+cr+"?\"");

      cbuf.flip();

      System.out.println( "!" + cbuf.toString() + "!" );
   }
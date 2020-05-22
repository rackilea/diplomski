int len = 0;
int expectedLength = sockInput.readInt();
byte[] buf = new byte[ expectedLength ];
while( len != buf.length ) {
   len += sockInput.read( buf, len, buf.length );
}

// now you have a buffer with expectedLength data in it.
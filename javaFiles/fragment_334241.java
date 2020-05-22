byte[] buffer = new byte[ ( string.length + 7 ) / 8 ];
for ( int i = 0; i < buffer.length; ++i ) {
   byte current = 0;
   for ( int j = 7; j >= 0; --j )
       if ( string[ i * 8 + j ] == '1' )
           current |= 1 << j;
   output( current );
}
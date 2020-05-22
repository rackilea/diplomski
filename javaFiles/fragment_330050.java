for( i = 0; i < buf1.length; i++ )
{
     if( buf1[ i ] == '\n' )
     {
         f1.write( "\r\n" );
     }
     else
     {
         f1.write( buf1[ i ] );
     }
     // ...
} // for
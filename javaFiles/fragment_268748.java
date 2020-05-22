byte[] bs = new byte[256];
String encode() throws Exception {
    return new String( bs, "ISO-8859-1" );
}
byte[] decode( String s ) throws Exception{
    return s.getBytes( "ISO-8859-1" );
}
 void set(){
    for( int i = 0; i < bs.length; ++i ){
        bs[i] = (byte)i;
    }
}
boolean cmp( byte[] x ){
    for( int i = 0; i < bs.length; ++i ){
        if( bs[i] != x[i] ){
            System.out.println( i + ": " + bs[i] + " != " + x[i] );
            return false;
         }
    }
    return true;
}
void round() throws Exception{
    String s = encode();
    if( s.length() != 256 ) throw new IllegalStateException();
        byte[] res = decode( s );
        if( ! cmp( res ) ) System.out.println( "false" );
    }
}
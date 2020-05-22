int rn = rd.nextInt( 1000001 );
byte[ ] bytes = new byte[ ] {
    ( byte ) ( ( rn >>>  0 ) & 0xFF ),
    ( byte ) ( ( rn >>>  8 ) & 0xFF ),
    ( byte ) ( ( rn >>> 16 ) & 0xFF ),
    ( byte ) ( ( rn >>> 24 ) & 0xFF )
};
fileos.write( bytes );
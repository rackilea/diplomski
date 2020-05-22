long mask ( long n ) { 
    long m   = n % 10;
    long n_d = n;
    long div = 10;
    int  shl = 0;
    while ( n_d >= 10 ) { 
        n_d /= 10;
        long t = n_d % 10;
        m |= ( t << ( shl += 4 ));
    }
    return m;
}

boolean findMatch( int a, int b ) { 
    if ( b < a  ) return false;
    if ( a == b ) return true;

    long m_a = mask( a );    // set up mask O(n)
    long m_b = mask( b );    // set up mask O(m)

    while ( m_a < m_b ) {
        if (( m_a & m_b ) == m_a ) return true;
        m_a <<= 4;  // shift - fast!
        if ( m_a == m_b ) return true;
    }  // O(p)
    return false;
}       

void testContains( int a, int b ) { 
    print( "findMatch( " + a + ", " + b + " )=" + findMatch( a, b ));
}

testContains( 12, 120 );
testContains( 12, 125 );
testContains( 123, 551241238 );
testContains( 131, 1214124 );
testContains( 131, 1314124 );
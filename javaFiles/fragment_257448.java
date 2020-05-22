boolean[] getKeyUsage( int mask ) {
    (7..0).collect { int it ->
        ( ( mask >> it ) & 1 )
    }
}

getKeyUsage( 144 ) == [ true, false, false, true, false, false, false, false ]
public static int pow( int a, int n) {
    if ( n == 0 ) {
        return 1;
    }
    if ( n % 2 == 1 ) {
        // Odd n
        return a * pow( a, n/2 ) * pow(a, n/2 );
    } else {
        // Even n
        return pow( a, n/2 ) * pow( a, n/2 );
    }
}
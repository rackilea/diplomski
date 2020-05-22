public static int pow( int a, int n) {
    if ( n == 0 ) {
        return 1;
    }
    int powerOfHalfN = pow( a, n/2 );
    if ( n % 2 == 1 ) {
        // Odd n
        return a * powerOfHalfN * powerOfHalfN;
    } else {
        // Even n
        return powerOfHalfN * powerOfHalfN;
    }
}
public static void printSplitNumber( int n ) {

    if ( n == 0 ) {
        return;
    }
    printSplitNumber( n / 10 );
    System.out.printf( "%d ", n % 10);
}
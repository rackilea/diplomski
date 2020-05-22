for ( int y = 0; y < n; y++ ) {
  for ( int x = 0; x < n; x++ ) {
    System.out.print( ( x == y ) ? '*' : ' ' );
  }
  for ( int x = n; x >= 0; x-- ) {
    System.out.print( ( x == y ) ? '*' : ' ' );
  }
  System.out.println();
}
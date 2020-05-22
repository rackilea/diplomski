for ( int y = -n; y <= n; y++ ) {
  for ( int x = -n; x <= n; x++ ) {
    System.out.print( hasAsterisk( Math.abs(x), Math.abs(y) ) ? '*' : ' ' );
  }
  System.out.println();
}
int x, y;
for ( y = -n; y <= n; y++ ) {
  for ( x = -n; x < 0; x++ ) {
    System.out.print( ( x == y || x == -y ) ? '*' : ' ' );
  }
  for ( ; x <= n; x++ ) {
    System.out.print( ( x == y || x == -y ) ? '*' : ' ' );
  }
  System.out.println();
}
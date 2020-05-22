public static int sqrt( int n ){
  int x = n;
  while( true ){
    int y = (x + n/x)/2;
    if( y >= x ) return x;
    x = y;
  }
}
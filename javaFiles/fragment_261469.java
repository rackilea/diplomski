public static int powerOf2Sum(int number) {
  if( number == 0 ) {
     return 1;
  }
  return (1 << number) + powerOf2Sum( number - 1 );
}
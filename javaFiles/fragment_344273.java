/** Computes the faculty of n */
public int faculty( n ) {
  if ( n > 1 )
    return n * faculty( n - 1 );
  return 1;
}
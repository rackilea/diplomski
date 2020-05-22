int average( int[] scores, int start, int end ) {
  int sum = 0;
  for ( int i = start; i < end; ++i ) {
    sum += scores[i];
  }
  return ( sum / ( end - start ) );
}
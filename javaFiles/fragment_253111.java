// compute the root of the biggests square that is a power of two < n
public static int pcomp( int n ){
  long p2 = 1;
  int i = 0;
  while( p2 < n ){
    p2 <<= 2;
    i += 2;
  }
  p2 >>= 2;
  i -= 2;
  return (int)(p2 >>= i/2);
}

public static int squareLowerThan( int n ){
  int p = pcomp(n);
  int p2 = p*p;     // biggest power of two that is a square < n 
  int d = 1;        // increase using odd numbers until n is exceeded
  while( p2 + 2*p + d < n ){
    p2 += 2*p + d;
    d += 2;
  }
  return p2;
}
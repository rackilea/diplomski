for(long n = Integer.MIN_VALUE; n <= Integer.MAX_VALUE; n++)
{
  int i = (int)n;

  int b1 = (i >> 24) & 0xff;
  int b2 = (i >> 16) & 0xff;
  int b3 = (i >>  8) & 0xff;
  int b4 = (i      ) & 0xff;

  //Now the IP is b1.b2.b3.b4
}
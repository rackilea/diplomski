public static int  bitCount(long i) {
   i = i - ((i >>> 1) & 0x5555555555555555L);
   i = (i & 0x3333333333333333L) + ((i >>> 2) & 0x3333333333333333L);
   i = (i + (i >>> 4)) & 0x0f0f0f0f0f0f0f0fL;
   i = i + (i >>> 8);
   i = i + (i >>> 16);
   i = i + (i >>> 32);
   return (int)i & 0x7f;
}
static int nextLower(int n) {
   int bc = Integer.bitCount(n);
   for (int i = n - 1; i > 0; i--)
     if (Integer.bitCount(i) == bc)
        return i;
   throw new RuntimeException(n+" is the lowest with a bit count of "+bc);
}
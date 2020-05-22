public static int getBinomial(int n, double p) {
  int x = 0;
  for(int i = 0; i < n; i++) {
    if(Math.random() < p)
      x++;
  }
  return x;
}
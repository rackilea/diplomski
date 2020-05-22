// takes integer
int n = input.nextInt();
// saves integer, for showing in results
int t = n;
// runs loop, takes sum and other stuff below
while (n > 0) {
      int p = n % 10;
      sum = sum + p;
      // here the n changes, that is why the value was saved in 't'
      n = n / 10;
}
public static int reverse (int n) {
     return IntStream.iterate (n, i -> i/10) // produces a infinite IntStream of n, n/10, 
                                             // n/100, ...
                     .limit(10) // 10 elements are sufficient, since int has <= 10 digits
                     .filter (i -> i > 0) // remove any trailing 0 elements
                     .map(i -> i % 10) // produce an IntStream of the digits in reversed 
                                       // order
                     .reduce (0, (r,i) -> r*10 + i); // reduce the reversed digits back
                                                     // to an int
}
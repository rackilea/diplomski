for (int i = 2; i <= n; i++) {

    // NEEDS TO BE RIGHT HERE - 
    boolean isPrime = true;
    // You are finding Prime Numbers, and the outer-loop (loop-var 'i')
    // Means the 'isPrime' needs to be re-initialized each time you start testing
    // whether a certain number, i, is prime or not!

    for (int j = 2; j < i; j++)
        if (i % j == 0) { isPrime = false; break; } 

    // and this line needs to be removed completely.
    // else { isPrime = true; }
    if (isPrime) System.out.println(i);
}
private static long Fib(long n) {
    long prev = 1;
    long current = 1;
    if (n <= 0) { System.out.println("Error"); return 0;}
    if (n == 1 | n == 2) return 1;
    for (int i = 3; i <= n; i++) {
        long next = prev + current;
        prev = current;
        current = next;
    }
    return current;

}
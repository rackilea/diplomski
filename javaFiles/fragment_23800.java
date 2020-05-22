public int fib(int n, int start1, int start2) {
    switch (n) {
        case 0: return start1;
        case 1: return start2;
        default: return fib(n-1, start1, start2) + fib(n-2, start1, start2);
    }
}
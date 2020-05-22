public static boolean isDivisibleBy3(int n) {
    if(n == 0) return true; 
    if(n == -1 || n == -2 || n == 1 || n == 2) return false; 
    if (n < 0) return isDivisibleBy3(n + 3); 
    else return isDivisibleBy3(n - 3); 
}
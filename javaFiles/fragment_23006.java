public static long factorial(int n) {   
    System.out.println("factorial("+n+")");
    if (n <= 1) { // factorial(0) = factorial(1) = 1
        System.out.println("return 1");
        return 1; 
    }
    long fac = factorial(n-1);
    System.out.printf("return %d * %d = %d%n", n, fac, n * fac);
    return n * fac;      
}
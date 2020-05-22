public static double getCos(double x) {
    double Cos = 0;
    for (int i = 0; i <= 5; i++) {
        Cos += (power(-1, i) * power(x, 2*i)) / factorial(2*i) ;
    }
    return Cos;
}

private static double factorial(int n) {
    int result = 1;

    if( n == 0 || n == 1 )
        return 1;
    else {
    for (int i = 1; i <= n; i++) {
        result = result * i;
    }
    return result;
    }
}

private static double power(double x, int n) {
    return Math.pow(x, n);
}

public static void main(String[] args) {

    System.out.println("Test For The 3 Methods!");
    System.out.println("5^2 : " + power(5, 2));
    System.out.println("4! : " + factorial(4));
    System.out.println("Cos(0.2) : " + getCos(0.2));
}
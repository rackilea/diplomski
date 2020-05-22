private static double power(double x, int n) {
    return Math.pow(x, n);
}

public static void main(String[] args) {

    System.out.println("Test For The 3 Methods!");
    System.out.println("5^2 : " + power(5, 2));
    System.out.println("4! : " + factorial(4));
    System.out.println("Cos(0.2) : " + getCos(0.2));
}
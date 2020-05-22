public static void printSum(int a, double b) {
    System.out.println("In intDBL " + (a + b));
} // int, double cannot be passed to long, long or double, long without error

public static void printSum(long a, long b) {
    System.out.println("In long " + (a + b));
} // long , long cannot be passed to int, double or double, long without error

public static void printSum(double a, long b) {
    System.out.println("In doubleLONG " + (a + b));
} // double, long cannot be passed to int, double or long, long without error
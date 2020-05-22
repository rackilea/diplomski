public static double angle(double a, double b, double c) {
    return Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
}

public static void main(String[] args) {
    System.out.println(angle(10, 10, 10));
    System.out.println(Math.toDegrees(angle(10, 10, 10)));
}
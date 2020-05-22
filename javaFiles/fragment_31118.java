public static void main(String[] args) {
    double y, x;
    for (x = 1.0; x <= 7.0; x += 0.1) {
        y = x * x - 5 * x + 6;
        System.out.printf("x = %f, y = %f", x, y); // or
        System.out.printf("x = %f, y = %f%n", x, y);
    }
}
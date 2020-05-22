class Main {
    public static void main(String[] args) {
        float x = 1.0f;
        float y = 1e-8f;
        float z = x + y;

        System.out.printf("%g\n", x);      // 1.00000
        System.out.printf("%g\n", y);      // 1.00000e-08
        System.out.printf("%g\n", z);      // 1.00000
        System.out.printf("%g\n", z - x);  // 0.00000

    }
}
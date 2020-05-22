public static void main(String[] args) {
    double z = 0.0;
    double x = 0.23;
    double y = 1.0 / x;
    int N = 50000;
    for (int i = 0; i < N; i++) {
        z += x * y - 1.0;
    }
    System.out.println("z should be zero, is " + z);
}
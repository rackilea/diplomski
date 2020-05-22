public static void main(String[] args) {
    int a = 3, N = 1000;
    System.out.println("Sum of multiples of " + a +
            " up to " + N + " = " +
            calculate_sum(a, N));

}

private static int calculate_sum(int a, int N) {
    // Number of multiples
    int m = N / a;

    // sum of first m natural numbers
    int sum = m * (m + 1) / 2;

    // sum of multiples
    return a * sum;
}
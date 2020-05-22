public static void main(String... ignored) {
    int twos = 0, fives = 0;
    Scanner in = new Scanner(System.in);
    while(in.hasNextLong()) {
        long n = in.nextLong();
        twos += factorsOf(n, 2);
        fives += factorsOf(n, 5);
    }
    System.out.printf("The product has %,d trailing zeros%n", Math.min(twos, fives));
}

public static int factorsOf(long n, int divisor) {
    int count = 0;
    while(n % divisor == 0) {
        n /= divisor;
        count++;
    }
    return count;
}
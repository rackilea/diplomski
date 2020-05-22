public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(getFibonacciLastDigit(n));
}

private static int getFibonacciLastDigit(int n) {
    if (n <= 1) {
        return n;
    }
    int first = 0;
    int second = 1;
    int temp;

    for (int i = 1; i < n; i++) {
        temp = (first + second) % 10;
        first = second;
        second = temp;
    }
    return second;
}
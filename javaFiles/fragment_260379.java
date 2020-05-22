public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
        int n = scanner.nextInt();
        System.out.println(getSum(n));
    }
}

public static long getSum(int n) {
    long sum = 0;
    for (int i = 3; i < n; i += 3) {
        sum += i;
    }
    for (int i = 5; i < n; i += 5) {
        if (i % 3 != 0) { // <-- already added if i is divisible by 3
            sum += i;
        }
    }
    return sum;
}
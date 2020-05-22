private void handle() {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for(int i = 0; i < T; i++) {
        findKthDigit(scanner);
    }
    scanner.close();
}

private void findKthDigit(Scanner scanner) {
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int k = scanner.nextInt();
    System.out.println((int)((Math.pow(a, b) % Math.pow(10, k))
            / Math.pow(10, k-1)));
}
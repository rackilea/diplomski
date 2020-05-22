public void fibonacci(int n) {
    BigInteger[] arr = new BigInteger[n + 1];

    arr[0] = BigInteger.ZERO;
    arr[1] = BigInteger.ONE;
    arr[2] = BigInteger.ONE;

    for (int i = 3; i <= n; i++) {
        arr[i] = arr[i - 1].add(arr[i - 2]);
    }

    System.out.println(arr[n]);
}
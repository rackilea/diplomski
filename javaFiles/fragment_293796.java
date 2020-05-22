public static void fibonacci(int n) {
    BigInteger[] array = new BigInteger[n];
    array[0] = array[1] = BigInteger.ONE;

    for (int i = 2; i < n; i++) {
        array[i] = array[i - 2].add(array[i - 1]);
    }
    System.out.println(array[n - 3] + "    " + array[n - 2]); // verify sum
    System.out.println(array[n - 1]);
}
public static void partition(int n) {

    for (int i = n; i >= 0; --i) {
        System.out.printf("[%d, %d] ", i, n - i);
    }
}
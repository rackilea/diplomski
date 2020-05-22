public static void main(final String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };// the array I'm working on
    for (int i = 1; i < 10; i++) {
        a[i] = a[i - 1]; // the manipulation given
        System.out.println(a[i]);
    }
}
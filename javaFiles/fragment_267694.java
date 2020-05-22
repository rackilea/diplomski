public static void printTable(int[] emirps) {
    for (int i = 0; i < 100; ++i) {
        System.out.printf("%d\t", emirps[i]);
        if (i % 10 == 9) {
            System.out.println();
        }
    }
}
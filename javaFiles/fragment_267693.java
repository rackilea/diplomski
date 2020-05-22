public static void printTable(int[] emirps) {
    for (int i = 0; i < 100; i += 10) {
        for (int j = 0; j < 10; j++) {
            // After 10 go to a new line
            System.out.printf("%d\t", emirps[i + j]);
        }
        System.out.println();
    }
}
public static void main(String... args) {
    int[] array1 = new int[95700];
    int[] array2 = new int[95700];
    for (int j = 0; j < array1.length; j += 3) {
        array1[j] = 0xFF0000FF;
        array2[j] = 0xFFFFFFFF;
    }
    long start = System.nanoTime();
    int runs = 10000;
    int matched = 0, unMatched = 0;
    for (int r = 0; r < runs; r++) {
        matched = unMatched = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0xFF0000FF && array2[i] == 0xFFFFFFFF) {
                matched++;
            } else {
                unMatched++;
            }
        }
    }
    long time = System.nanoTime() - start;
    System.out.printf("The array comparison to an average of %.6f second, matched=%,d, unmatched=%,d%n",
            time / 1e9 / runs, matched, unMatched);
}
public static void main(String[] args) {
    int[] array = { 5, 1, 2, 2, -1, 1, 5, 4 };
    int[] results = new int[array.length];
    int minCount = Integer.MAX_VALUE;
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            if (array[j] == array[i]) {
                results[i]++;
            }
        }
        if (results[i] <= minCount) {
            minCount = results[i];
        }
    }
    for (int i = 0; i < results.length; i++) {
        if (results[i] == minCount) {
            System.out.println("Element: " + i + ", Number of occurences: "
                    + minCount);
        }
    }
}
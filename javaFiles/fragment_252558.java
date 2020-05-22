public static void insertionSort2(int[] input) {
    int temp;
    for (int i = 1; i < input.length; i++) {
        for (int j = i; j > 0; j--) {
            if (input[j] < input[j - 1]) {
                temp = input[j];
                input[j] = input[j - 1];
                input[j - 1] = temp;
            } else {
                break; // this is the "early break" missing.
            }
        }
    }
}
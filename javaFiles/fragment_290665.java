public static void main(String[] args) {
    int[] input = {12, 21, 21, 1, 4, 5, 66, 74, 0, -2, 5, 3, 5, 3, 2, 1}; // the input to be sorted.
    int key; // the value that will be put into its place in the pass
    int j = 0; // indexes to be 
    int i = 0; // used for sorting

    for (i = 1; i < input.length; i++) {
        key = input[i];
        j = i;
        while (j > 0 && input[j - 1] > key) {
            input[j] = input[j - 1];
            j--;
        }
        input[j] = key;
    }

    for (int each : input) {
        System.out.println(each);
    }
}
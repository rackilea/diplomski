public static void main(String[] args) {
    int[] values = { 8, 5, 9, 8, 6, 13, 33, 1, 98, 12, 8, 1 };
    Arrays.sort(values);
    for (int i = 1; i < values.length; i++) {
        if (values[i] == values[i - 1]) {
            System.out.println("Duplicates in Array: " + values[i]);
            while (values[i] == values[i - 1]) { // <-- add this
                i++;
            }
        }
    }
}
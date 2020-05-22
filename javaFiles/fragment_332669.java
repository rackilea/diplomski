public static void main(String[] args) {
    // Use the Wrapper class, otherwise you can´t call Arrays.sort with a comperator.
    Integer[] array = {2, 6, 4, 1};
    Arrays.sort(array, Collections.reverseOrder());
    for (int num : array) {
        System.out.println(num);
    }
}
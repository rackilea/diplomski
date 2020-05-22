public static void main(String... args) {
    int[][] ints = new int[100][500_000];
    for (int[] arr : ints) {
        Arrays.fill(arr, 1);
    }
}
public static void main(String[] args) {
    int[][] numbers = { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 },
            { 1, 2, 3, 4, 5 } };
    int[][] newNumbers = reorganize(numbers);
    System.out.println(Arrays.deepToString(newNumbers));
}
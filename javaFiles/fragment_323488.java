int matrix[][] = { { 4, 0 }, { 2, 1 } };
int array[] = { 19, 7, 8, 18, 8, 18, 0, 19, 4, 23, 19, 25 };
List<Integer> result = new ArrayList<>();
for (int i = 0; i < array.length; i++) {
    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[0].length; col++) {
            result.add(array[i] * matrix[row][col]);
        }
    }
}
System.out.println(result); // <-- display the result of matrix multiplication.
// Add pairs.
for (int i = 0; i + 1 < result.size(); i += 2) {
    int a = result.get(i);
    int b = result.get(i + 1);
    int total = a + b;
    System.out.printf("%d. %d + %d = %d%n", i, a, b, total);
}
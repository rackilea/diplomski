int size = 4;
int[][] matrix = new int[size][size];
// . . .
for (int i = 0; i < size; ++i) {
    doSomethingWith(matrix[i][size - i - 1]);
}
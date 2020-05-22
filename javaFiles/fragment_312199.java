int[] ints = new int[36];
// fill with values
int[][] matrix = new int[6][6];
for (int i = 0; i < ints.length; i++) {
    matrix[i / 6][i % 6] = ints[i];
}
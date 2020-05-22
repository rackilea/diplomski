public static int[][] deepCopyIntMatrix(int[][] input) {
if (input == null)
    return null;
int[][] result = new int[input.length][];
for (int r = 0; r < input.length; r++) {
    result[r] = input[r].clone();
}
return result;
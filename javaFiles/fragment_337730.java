public static int[][] copyMatrix(int[][] matrix) 
{
    if (matrix.length < 1) {
        return new int[0][0];
    }
    int[][] duplicateMatrix = new int[matrix.length][matrix[0].length];
    for (int i = 0; (i < matrix.length); i++)
    {
            for (int j = 0; (j < matrix[i].length); j++)
            {
                duplicateMatrix[i][j] = matrix[i][j];
            }
    }
    return duplicateMatrix;
}
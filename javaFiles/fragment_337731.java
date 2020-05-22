public static int[][] copyMatrix(int[][] matrix) 
{
    int[][] duplicateMatrix = new int[matrix.length][];
    for (int i = 0; (i < matrix.length); i++)
    {
            duplicateMatrix[i] = new int[matrix[i].length];
            for (int j = 0; (j < matrix[i].length); j++)
            {
                duplicateMatrix[i][j] = matrix[i][j];
            }
    }
    return duplicateMatrix;
}
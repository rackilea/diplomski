public static void main(String[] args)
{
    int[][] matrix = getMatrix(10000);
    for (int i=0; i<matrix.length; i++)
        System.out.println(matrix[i][0]+" "+matrix[i][1]);
}
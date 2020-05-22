public T[][] getTranspose(Class<T> arrayType, T[][] matrix, int rows, int cols)
{

    T[][] transpose = (T[][]) Array.newInstance(arrayType, rows,cols);
    for (int x = 0; x < cols; x++)
    {
        for (int y = 0; y < rows; y++)
        {
            transpose[x][y] = matrix[y][x];
        }
    }
    return transpose;
}

public static void main(String args[]) {
    MatrixOperations<Integer> mo = new MatrixOperations<>();
    Integer[][] i = mo.getTranspose(Integer.class, new Integer[2][2], 2, 2);
    i[1][1] = new Integer(13);  
}
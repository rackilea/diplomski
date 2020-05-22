public static int getAt(int[][] matrix, int position) {
    int columns = matrix[0].length; // column size, matrix has to be at least 1x1
    return matrix[position / columns][position % columns];
}

public static void setAt(int[][] matrix, int position, int value) {
    int columns = matrix[0].length; // column size, matrix has to be at least 1x1
    matrix[position / columns][position % columns] = value;
}
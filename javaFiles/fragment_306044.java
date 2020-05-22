Integer[][] fillMatrix() {
Integer[][] matrix = new Integer[5][4];
for (int row = 0; row < 5; row++)
    for (int column = 0; column < 4; column++)
        matrix[row][column] = row * column;
 return matrix;
}
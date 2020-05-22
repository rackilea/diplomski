public Face rotateRight(){
    int rows = 3;
    int cols = 3;
    int[][] transposedArray = new int[3][3];

    for (int i = 0; i<rows; i++){
        for (int j = 0; j<cols; j++){
            transposedArray[j][2-i]=grid[i][j];
        }
    }
    return new Face(transposedArray);
}
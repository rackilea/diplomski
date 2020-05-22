char[][] array = new char[4][4];

public static void move(row, column){
    for (int i = 0, i < 4; i++) {
        for (int j = 0; j < 4; j++){
            if (array[i][j] != null) {
                // add rows and column accordingly
                array[i + row][j + column] = array[i][j];
                array[i][j] = null;
            }
        }
    }
}
public void createArray(int height, int width){

    this.boardArray = new int [height][width];

    for (int i = 0; i < height; ++i){
        for (int j = 0; j < width; ++j){ //change i to j
            if (i == 0 || i == height - 1){ // also fill last row with ones
                this.boardArray[i][j] = 1;
            }
        }
    }
}
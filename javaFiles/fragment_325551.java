public void createArray(int height, int width){

    this.boardArray = new int [height][width];
    if(height > 0) {
        Arrays.fill(this.boardArray[0], 1);
        if(height > 1) {
            Arrays.fill(this.boardArray[height - 1], 1);
        }
    }
}
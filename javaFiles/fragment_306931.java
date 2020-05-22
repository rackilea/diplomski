public boolean getCell(int row, int col) {
    boolean state = board[row][col];
    int neighbors = 0;//you are summing the alive neighbours 
       //keep var declaration outside the iteration over them

    for (int x = Math.max(0,row-1); x < Math.min(row+2,NROWSCOLS); x++) {
        for (int y = Math.max(0,col-1); y < Math.min(col+2,NROWSCOLS); y++) {
            //using min and max to ensure x and y remain between 0 and NROWSCOLS 
            //so no IOBException
                if (board[x][y] == ALIVE){
                    neighbors ++;

                }
            }
        }
    }
    if (neighbors > 3 || neighbors < 2)//only do the check when you are finished counting the alive neighbours
        state = DEAD;
    else if(neighbors == 3)
        state = ALIVE;
    return state;
}
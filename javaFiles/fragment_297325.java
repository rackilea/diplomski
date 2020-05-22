public Player colWinner(){
    for(int col = 0; col < grid[0].length; col++){
        for(int row = 0; row < grid.length/2; row++){
            Player currP = getCell(row,col);
            if(currP != null && currP == getCell(row + 1, col) && currP == getCell(row + 2, col) && currP == getCell(row + 3, col)){ 
                return currP;
            }
        }
        for(int row = grid.length/2; row < grid.length; row++){
            Player currP = getCell(row,col);
            if(currP != null && currP == getCell(row - 1, col) && currP == getCell(row - 2, col) && currP == getCell(row - 3, col)){ 
                return currP;
            }
        }
    }
    return null;
}
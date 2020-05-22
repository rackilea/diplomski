public boolean isInGrid(int x, int y) {
    //Check if a position is valid in the grid
    if(i < 0 || j < 0) return false;
    if(i >= WIDTH || j >= HEIGHT) return false;
    return true;
}

...

if(isInGrid(i-1, j-1) && model.get(i-1, j-1) == MinerGridCo.UNTURNED_MINE) count++;
if(isInGrid(i+1, j+1) && model.get(i+1, j+1) == MinerGridCo.UNTURNED_MINE) count++;
//Repeat for each location you want to check
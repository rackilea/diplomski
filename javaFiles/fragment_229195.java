if (i - 1 >= 1){
        if (grid[i - 2][j] != 0){
            return xyTo1D(i - 1, j);
        }
       return -1; //OR whatever int you would like to return
    }
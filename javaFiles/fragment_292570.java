short numNeighbors(int x, int y) {
    short numNeighbors; 
    numNeighbors = 0;
    if(x > 0 && y > 0 && matrix[x][y] != null){
        if (matrix[j][i] != null && matrix[x+1][y] == true) numNeighbors++;
        if (matrix[j][i] != null && matrix[x][y+1] == true) numNeighbors++;
        if (matrix[j][i] != null && [x+1][y+1] == true) numNeighbors++;
        if (matrix[j][i] != null && matrix[x][y-1] == true) numNeighbors++;
        if (matrix[j][i] != null && matrix[x-1][y] == true) numNeighbors++;
        if (matrix[j][i] != null && matrix[x+1][y-1] == true) numNeighbors++;
        if (matrix[j][i] != null && matrix[x-1][y+1] == true) numNeighbors++;
        if (matrix[j][i] != null && matrix[x-1][y-1] == true) numNeighbors++;
    }
    return numNeighbors;
}
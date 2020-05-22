private boolean solveMaze(int coorda, int coordb) { 
    return solveMaze(coorda, coordb, 0, 0);
}

private boolean solveMaze(int coorda, int coordb, int dx, int dy) { 

    switch (myMaze[coorda][coordb]) {
        case '#': case 'X': return false;
        case 'E': return true;
    }

    myMaze[coorda][coordb] = 'X';

    if (dx >= 0 && solveMaze(coorda + 1, coordb, +1, 0) || // W
        dx <= 0 && solveMaze(coorda - 1, coordb, -1, 0) || // E
        dy >= 0 && solveMaze(coorda, coordb + 1, 0, +1) || // S
        dy <= 0 && solveMaze(coorda, coordb - 1, 0, -1)) { // N
        return true;
    }       

    myMaze[coorda][coordb] = ' ';
    return false;
}
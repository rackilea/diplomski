static int countPaths(boolean[][] grid) {
    int freeSquares = 0;
    for(int y = 0; y < grid.length; y++) {
        for(int x = 0; x < grid[y].length; x++) {
            if(grid[y][x]) freeSquares++;
        }
    }
    return _countPaths(grid, 0, 0, freeSquares);
}

static int _countPaths(boolean[][] grid, int x, int y, int freeSquares) {
    if(!grid[y][x]) return 0;
    if(y == grid.length-1 && x == 0) { // bottom left
        if(freeSquares == 1) return 1;
        else return 0;
    }
    int sum = 0;
    grid[y][x] = false;
    for(int dy = -1; dy <= 1; dy++) {
        for(int dx = -1; dx <= 1; dx++) {
            int newX = x+dx, newY = y+dy;
            if(newX < 0 || newY < 0 || newY >= grid.length || newX >= grid[y].length) continue;
            if((dx == 0 && dy == 0) || (dx != 0 && dy != 0)) continue;
            sum += _countPaths(grid, x+dx, y+dy, freeSquares-1);
        }
    }
    grid[y][x] = true;
    return sum;
}

public static void main (String args[]) {
    boolean[][] grid = {{true, true, true, false},
                        {true, true, true, false},
                        {true, true, true,  true},
                        {true, true, true,  true}};
    System.out.println(countPaths(grid));
}
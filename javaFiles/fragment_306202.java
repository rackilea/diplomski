// add all valid neighbors of a cell to the list
    // where "valid" means: indices inside the maze
private static void addNeighbors(Cell cell, List<Cell> list, 
                                      int maxRow, int maxCol) {
    int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int[] d : ds) {
        int row = cell.row + d[0];
        int col = cell.col + d[1];          
        if (isValid(row, col, maxRow, maxCol))
            list.add(new Cell(row, col));
    }
}

// find the neighbor of a cell having a certain distance from the start        
private static Cell getNeighbor(Cell cell, int distance, int[][] distances) {
    int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int[] d : ds) {
        int row = cell.row + d[0];
        int col = cell.col + d[1];          
        if (isValid(row, col, distances.length, distances[0].length)
                && distances[row][col] == distance)
            return new Cell(row, col);              
    }
    return null;
}

// check if coordinates are inside the maze
private static boolean isValid(int row, int col, int maxRow, int maxCol) {
    return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
}
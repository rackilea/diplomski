public static int shortestPath(String[][] map, Cell start, Cell end, 
                                                           Stack<Cell> path) {
    // initialize distances array filled with infinity
    int[][] distances = new int[map.length][];
    for (int i = 0; i < map.length; i++) {
        distances[i] = new int[map[i].length];
        Arrays.fill(distances[i], Integer.MAX_VALUE);
    }

    // the start node should get distance 0
    int distance = 0;
    List<Cell> currentCells = Arrays.asList(start);

    while (distances[end.row][end.col] == Integer.MAX_VALUE
                && !currentCells.isEmpty()) {
        List<Cell> nextCells = new ArrayList<>();

        // loop over all cells added in previous round
        // set their distance 
        //    and add their neighbors to the list for next round
        for (Cell cell : currentCells) {
            if (distances[cell.row][cell.col] == Integer.MAX_VALUE 
                    && !map[cell.row][cell.col].equals("1")) {
                distances[cell.row][cell.col] = distance;
                addNeighbors(cell, nextCells, map.length, map[0].length);
            }
        }

        // prepare for next round
        currentCells = nextCells;
        distance++;
    }

    // find the path
    if (distances[end.row][end.col] < Integer.MAX_VALUE) {
        Cell cell = end;
        path.push(end);
        for (int d = distances[end.row][end.col]-1; d >= 0; d--) {
            cell = getNeighbor(cell, d, distances);
            path.push(cell);
        }
    }

    return distances[end.row][end.col];
}
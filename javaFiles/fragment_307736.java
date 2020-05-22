public void search(String[][] grid) {
    int cellsSearched = 0;
    List<Point> cLocations = new ArrayList<>();
    List<Point> sLocations = new ArrayList<>();

    boolean[][] map = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            if (cLocations.size() == 5 && sLocations.size() == 3) break;
            if(!map[i][j]) {
                if (grid[i][j].equals("S")) {
                    getSeries(i, j, "S", grid, map, sLocations);
                } else if (grid[i][j].equals("C")) {
                    getSeries(i, j, "C", grid, map, sLocations);
                }
            }
            cellsSearched++;
        }
    }
}

public boolean inbounds(int i, int j, String[][] grid) {
    return ( 0 <= i && i < grid.length ) && ( 0 <= j && j < grid[i].length );
}

public void getSeries(int i, int j, String toFind,String[][] grid, boolean map[][], ArrayList<Point> locations) {

    /**
     * This function basically checks if 'i' and 'j' are safe so that accessing grid[i][j]
     * would not cause ArrayOutOfBoundsException
     */
    if(!inbounds(i, j, grid)) {
        return;
    }

    String matched = grid[i][j];
    if(!map[i][j] && matched.equals(toFind)) {
        map[i][j] = true;
        locations.add(new Point(i, j));

        // Going up
        getSeries(i - 1, j, toFind, grid, map, locations);

        // Going down
        getSeries(i + 1, j, toFind, grid, map, locations);

        // Going left
        getSeries(i, j - 1, toFind, grid, map, locations);

        // Going right
        getSeries(i, j + 1, toFind, grid, map, locations);

        /*
        (i+1, j-1) -> Going Bottom Left
        (i+1, j+1) -> Going Bottom Right

        (i-1, j-1) -> Going Top Left
        (i-1, j+1) -> Going Top Right 
        */
    }
}
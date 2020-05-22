boolean isOccupied(Integer x, Integer y) {
    if(x < 0 || y < 0 || x >= numberOfColumns || y >= numberOfRows) {
        // Attempting to check outside the grid: it's non-occupied.
        return false;
    }

    return !this.field[x][y].equals("**");
}
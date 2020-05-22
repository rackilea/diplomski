private List<Location> getLocationsForRowAndPosition(int activeRow, int activePos,
        List<Location> locations) {
    int minRow = activeRow;
    int maxRow = ((activeRow & 1) == 0) ? activeRow + 1 : activeRow;    // If even, then pair includes the next higher row
    List<Location> positionLocations = new ArrayList<Location>();
    for (Location location : locations) {
        if (location.row >= minRow && location.row <= maxRow && location.position == activePos)
            positionLocations.add(location);
    }
    return positionLocations;
}
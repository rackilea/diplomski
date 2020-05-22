private List<Location> getLocationsForRowAndPosition(int activeRow, int activePos,
        List<Location> locations) {
    int minRow = activeRow;
    int maxRow = ((activeRow & 1) == 0) ? activeRow + 1 : activeRow;    // If even, then pair includes the next higher row
    return locations.stream().filter(location -> location.row >= minRow && location.row <= maxRow && location.position == activePos)
            .collect(Collectors.toList());
}
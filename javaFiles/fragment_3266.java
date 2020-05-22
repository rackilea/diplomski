private List<Location> minimizeHeight(int currentHeight, List<Location> activePositionLocations) {
    List<Location> optimizedHeightLocations = new ArrayList<Location>();

    int minHeight = Integer.MAX_VALUE;
    int maxHeight = Integer.MIN_VALUE;
    for (Location location : activePositionLocations) {
        if (location.height < minHeight)
            minHeight = location.height;
        if (location.height > maxHeight)
            maxHeight = location.height;
    }

    /*
     * There are only two options to minimize (if the current height falls between min and max):
     * 1)  Travel down then up
     * 2)  Travel up then down
     */
    // First determine the first direction to go
    Direction direction;
    if (currentHeight == minHeight)
        direction = Direction.UP;
    else if (currentHeight == maxHeight)
        direction = Direction.DOWN;
    else {
        int distanceUp = maxHeight-currentHeight;
        int distanceDown = currentHeight-minHeight;
        direction = distanceUp < distanceDown ? Direction.UP : Direction.DOWN;
    }
    // Now travel in that direction (must sort the correct way first
    List<Location> sortedAscending = new ArrayList<Location>(activePositionLocations);  // Clone it
    Collections.sort(sortedAscending, new Comparator<Location>() {
        @Override
        public int compare(Location l1, Location l2) {
            return Integer.compare(l1.height, l2.height);
        }
    });
    List<Location> sortedDescending = new ArrayList<Location>(activePositionLocations); // Clone it
    Collections.sort(sortedDescending, new Comparator<Location>() {
        @Override
        public int compare(Location l1, Location l2) {
            return Integer.compare(l2.height, l1.height);
        }
    });

    if (direction == Direction.UP) {
        for (Location location : sortedAscending) {
            if (location.height >= currentHeight)
                optimizedHeightLocations.add(location);
        }
        for (Location location : sortedDescending) {
            if (location.height < currentHeight)
                optimizedHeightLocations.add(location);
        }
    } else {    // Direction = DOWN
        for (Location location : sortedDescending) {
            if (location.height <= currentHeight)
                optimizedHeightLocations.add(location);
        }
        for (Location location : sortedAscending) {
            if (location.height > currentHeight)
                optimizedHeightLocations.add(location);
        }
    }

    return optimizedHeightLocations;
}
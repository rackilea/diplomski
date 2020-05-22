private int getNextPos(int currentPosition, List<Location> locations) {
    if (locations.isEmpty())
        return 0;
    int minValue = Integer.MAX_VALUE;
    for (Location location : locations) {
        if (location.position > currentPosition && location.position < minValue)
            minValue = location.position;
    }
    return minValue == Integer.MAX_VALUE ? 0 : minValue;
}
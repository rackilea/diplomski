private int getNextRow(List<Location> locations) {
    if (locations.isEmpty())
        return 0;
    int minValue = Integer.MAX_VALUE;
    for (Location location : locations) {
        if (location.row < minValue)
            minValue = location.row;
    }
    return minValue;
}
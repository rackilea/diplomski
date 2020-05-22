public class ForkLiftOperator {

public static void main(String[] args) {
    new ForkLiftOperator().start();
}

private void start() {

    List<Location> locations = new ArrayList<Location>();
    locations.add(new Location(30, 9, 5));
    locations.add(new Location(30, 4, 5));
    locations.add(new Location(30, 2, 1));
    locations.add(new Location(31, 7, 5));
    locations.add(new Location(31, 7, 4));
    locations.add(new Location(31, 3, 5));
    locations.add(new Location(31, 3, 6));
    locations.add(new Location(31, 9, 5));
    locations.add(new Location(31, 2, 5));
    locations.add(new Location(32, 2, 5));  // Extra to simulate additional row/pair

    List<Location> solution = solve(locations);
    System.out.println(solution);
}


private List<Location> solve(List<Location> locations) {

    List<Location> shortestPath = new ArrayList<Location>();
    int activeRow, activePosition, activeHeight;
    while ((activeRow = getNextRow(locations)) != 0) {
        System.out.println("Working on row="+activeRow);
        List<Location> activeLocations = getLocationsByRowPair(activeRow, locations);
        activePosition = 0;
        activeHeight = 0;
        while ((activePosition = getNextPos(activePosition, activeLocations)) != 0) {
            System.out.println("Working on pos="+activePosition);
            List<Location> activePositionLocations = getLocationsForRowAndPosition(activeRow, activePosition, activeLocations);
            shortestPath.addAll(minimizeHeight(activeHeight, activePositionLocations));
            activeHeight = shortestPath.get(shortestPath.size()-1).height;
        }
    }


    return shortestPath;
}

enum Direction { UP, DOWN }
/**
 * For the given locations (which are guaranteed to be at the same row/position), minimize the total height change
 * @param activePositionLocations The locations at this row/pair and location (they will only differ in height)
 * @return The order will minimize the height change
 */
private List<Location> minimizeHeight(int currentHeight, List<Location> activePositionLocations) {
    List<Location> optimizedHeightLocations = new ArrayList<Location>();
    System.out.println("Processing locations="+activePositionLocations);
    int minHeight = activePositionLocations.stream().mapToInt(location -> location.height).min().getAsInt();
    int maxHeight = activePositionLocations.stream().mapToInt(location -> location.height).max().getAsInt();
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
    List<Location> sortedAscending = activePositionLocations.stream().sorted((l1, l2) -> Integer.compare(l1.height, l2.height)).collect(Collectors.toList());
    List<Location> sortedDescending = activePositionLocations.stream().sorted((l1, l2) -> Integer.compare(l2.height, l1.height)).collect(Collectors.toList());
    if (direction == Direction.UP) {
        optimizedHeightLocations.addAll(sortedAscending.stream().filter(location -> location.height >= currentHeight).collect(Collectors.toList()));
        optimizedHeightLocations.addAll(sortedDescending.stream().filter(location -> location.height < currentHeight).collect(Collectors.toList()));
    } else {    // Direction = DOWN
        optimizedHeightLocations.addAll(sortedDescending.stream().filter(location -> location.height <= currentHeight).collect(Collectors.toList()));
        optimizedHeightLocations.addAll(sortedAscending.stream().filter(location -> location.height > currentHeight).collect(Collectors.toList()));
    }

    return optimizedHeightLocations;
}

/**
 * Determine all the locations for this current row/pair and position
 * @param activeRow The current row/pair
 * @param activePos The current position
 * @param locations The locations for this row/pair
 * @return The locations at this exact row/pair and position
 */
private List<Location> getLocationsForRowAndPosition(int activeRow, int activePos,
        List<Location> locations) {
    int minRow = activeRow;
    int maxRow = ((activeRow & 1) == 0) ? activeRow + 1 : activeRow;    // If even, then pair includes the next higher row
    return locations.stream().filter(location -> location.row >= minRow && location.row <= maxRow && location.position == activePos)
            .collect(Collectors.toList());
}

/**
 * Determine the next position, given the current position
 * @param currentPosition Where the operator is currently
 * @param locations The locations for this row/pair
 * @return The next closest, or zero if they are at the end
 */
private int getNextPos(int currentPosition, List<Location> locations) {
    if (locations.isEmpty())
        return 0;
    OptionalInt min = locations.stream().filter(location -> location.position > currentPosition)
            .mapToInt(location -> location.position)
            .min(); 
    return min.isPresent() ? min.getAsInt() : 0;
}

/**
 * Filter out any locations for this row pair.
 * The locations for this row will be removed from the original list
 * @param nextRow The current row being processed
 * @param locations The remaining locations
 * @return The locations for the active row
 */
private List<Location> getLocationsByRowPair(int nextRow, List<Location> locations) {
    List<Location> activeLocations = new ArrayList<Location>();
    Iterator<Location> i = locations.iterator();
    int minRow = nextRow;
    int maxRow = ((nextRow & 1) == 0) ? nextRow + 1 : nextRow;  // If even, then pair includes the next higher row
    while (i.hasNext()) {
        Location current = i.next();
        if (current.row >= minRow && current.row <= maxRow) {
            activeLocations.add(current);
            i.remove();
        }
    }
    return activeLocations;
}

/**
 * Determine the lowest row from the locations provided
 * @param locations All remaining locations
 * @return The minimum row number remaining
 */
private int getNextRow(List<Location> locations) {
    if (locations.isEmpty())
        return 0;
    return locations.stream().mapToInt(location -> location.row)
            .min().getAsInt();
}

class Location {
    final int row;
    final int position;
    final int height;
    public Location(int row, int height, int position) {
        this.row = row;
        this.position = position;
        this.height = height;
    }
    @Override
    public String toString() {
        return "[" + row + ", " + height + ", " + position + "]";
    }

}
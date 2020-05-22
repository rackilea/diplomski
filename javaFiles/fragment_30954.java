private static List<List<Location>> options = new ArrayList<List<Location>>();
public static void PathFind(List<Location> path) {
    Location current = path.get(path.size() - 1);
    boolean done = false;
    if (locationEquals(current, new Location(24, 38))) {
        options.add(path);
        return;
    }
    if (path.size() > 50) done = true;
    if (!done) {
        try {
            if (map[current.row][current.col + 1] == 0) {
                if (!path.contains(new Location(current.row, current.col + 1))) {
                    List<Location> temp = new ArrayList<>(path);
                    temp.add(new Location(current.row, current.col + 1));
                    PathFind(temp);
                }
            }
        } catch (Exception e) {
        }
        try {
            if (map[current.row - 1][current.col] == 0) {
                if (!path.contains(new Location(current.row - 1, current.col))) {
                    List<Location> temp = new ArrayList<>(path);
                    temp.add(new Location(current.row - 1, current.col));
                    PathFind(temp);
                }
            }
        } catch (Exception e) {
        }
        try {
            if (map[current.row][current.col - 1] == 0) {
                if (!path.contains(new Location(current.row, current.col - 1))) {
                    List<Location> temp = new ArrayList<>(path);
                    temp.add(new Location(current.row, current.col - 1));
                    PathFind(temp);
                }
            }
        } catch (Exception e) {
        }
        try {
            if (map[current.row + 1][current.col] == 0) {
                if (!path.contains(new Location(current.row + 1, current.col))) {
                    List<Location> temp = new ArrayList<>(path);
                    temp.add(new Location(current.row + 1, current.col));
                    PathFind(temp);
                }
            }
        } catch (Exception e) {
        }
    }
}
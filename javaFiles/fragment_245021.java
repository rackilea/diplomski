enum Direction {
    LEFT(-1, 0),
    UPPERLEFT(-1, -1),
    DOWN(0, - 1),
    ...;

    public final int xoffset;
    pubiic final int yoffset;

    Direction(int xoffset, int yoffset) {
        this.xoffset = xoffset;
        this.yoffset = yoffset;
    }

    public static GridObject getRelativeItem(GridObject[][] grid, int x, int y, Direction dir) {
        return grid[x + dir.xoffset][y + dir.yoffset];
    }

    public static void setRelativeItem(GridObject[][] grid, int x, int y, Direction dir, GridObject newValue) {
        grid[x + dir.xoffset][y + dir.yoffset] = newValue;
    } 
}
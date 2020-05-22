public static Color copy(Color[][] grid) {
    Color[][] copied = new Color[grid.length][];
    for (int i = 0; i < grid.length; ++i) {
        copied[i] = Arrays,copyOf(grid[i], grid[i].length);
    }
    return copied;
}
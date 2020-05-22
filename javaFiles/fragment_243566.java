public static void findPath(int grid[][], Point000 start, Point000 end, ArrayList<Point000> currentPath)
{
    currentPath.add(start);

    if(start.x == end.x && start.y == end.y)
    {
        System.out.println(currentPath);
        return;
    }

    if(start.x + 1 < grid.length)
    {
        findPath(grid, new Point000(start.x + 1, start.y), end, new ArrayList<>(currentPath));
    }

    if(start.y + 1 < grid[0].length)
    {
        findPath(grid, new Point000(start.x, start.y + 1), end, new ArrayList<>(currentPath));
    }

}
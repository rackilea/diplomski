public class PointSet implements Set<Point> {
    private final boolean[][] data; 
    public PointSet(int xSize, int ySize) {
        data = new boolean[xSize][ySize];
    }

    @Override
    public boolean add(Point e) {
         boolean hadIt = data[e.x][e.y];
         data[e.x][e.y] = true;
         return hadIt;
    }

    @Override
    public boolean contains(Object o) {
        Point p = (Point) o;
        return data[p.x][p.y];
    }

    //...other methods of Set<Point>...
}
public class Map {
    public Point[][] points;
    public char[][] colors;

    public getColorOfPoint(Point point) {
        return colors[point.x, point.y];
    }

    public Map(Point[][] points, char[][] colors) {
        this.points = points;
        this.colors = colors;
    }
}
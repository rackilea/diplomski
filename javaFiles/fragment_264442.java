public class Triangle {

  private Point[] coords;

  // Null object constructor
  public Triangle() {
    this.coords = null;
  }

  // Constructor with point array
  public Triangle(Point[] coords) {
    this.coords = coords;
  }

  // Constructor with multiple points
  public Triangle(Point a, Point b, Point c) {
    this.coords = new Point[3];
    coords[0] = a;
    coords[1] = b;
    coords[2] = c;
  }

  // The actual paint method
  public void paint(Graphics arg0) {
    // Setup local variables to hold the coordinates
    int[] x = new int[3];
    int[] y = new int[3];
    // Loop through our points
    for (int i = 0; i < coords.length; i++) {
        Point point = coords[i];
        // Parse out the coordinates as integers and store to our local variables
        x[i] = Double.valueOf(point.getX()).intValue();
        y[i] = Double.valueOf(point.getY()).intValue();
    }
    // Actually commit to our polygon
    arg0.drawPolygon(x, y, 3);
  }
}
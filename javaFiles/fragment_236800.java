import java.awt.geom.Point2D;
    import java.awt.geom.Line2D;
    import java.awt.geom.QuadCurve2D;
    import java.util.Iterator;
    import java.util.ArrayList;

    public final class TestGradientLine {

    private static int SIZE = 3;

    public TestGradientLine() {
        super();
    }

    //y = mx + b
    //b = y - mx
    //m is rise / run = gradient
    //width and height of bounding box
    //for a box 10x10 then width and height are 9,9
    public static Line2D getGradientLine(double run, double rise, double width, double height, double x, double y) {
        if (run == 0 && rise == 0) {
     return new Line2D.Double(x, y, x + width, y + height);
        }

        //calculate hypotenuse
        //check for a vertical line
        if (run == 0) {
     return new Line2D.Double(x, y, x, y + height);
        }
        //check for a horizontal line
        if (rise == 0) {
     return new Line2D.Double(x, y, x + width, y);
        }
        //calculate gradient
        double m = rise / run;
        Point2D start;
        Point2D opposite;
        if (m < 0) {
     //lower left
     start = new Point2D.Double(x, y + height); 
     opposite = new Point2D.Double(x + width, y); 

        } else {
     //upper left 
     start = new Point2D.Double(x, y);
     opposite = new Point2D.Double(x + width, y + height); 
        }
        double b = start.getY() - (m * start.getX());

        //now calculate another point along the slope
        Point2D next = null;
        if (m > 0) {
     next = new Point2D.Double(start.getX() + Math.abs(run), start.getY() + Math.abs(rise));
        } else {
     if (rise < 0) {
  next = new Point2D.Double(start.getX() + run, start.getY() + rise);
     } else {
  next = new Point2D.Double(start.getX() - run, start.getY() - rise);
     }
        }
        final double actualWidth = width;
        final double actualHeight = height;
        final double a = Math.sqrt((actualWidth * actualWidth) + (actualHeight * actualHeight));
        extendLine(start, next, a);
        Line2D gradientLine = new Line2D.Double(start, next);
        return gradientLine;

    }

    public static void extendLine(Point2D p0, Point2D p1, double toLength) {
        final double oldLength = p0.distance(p1);
        final double lengthFraction =
     oldLength != 0.0 ? toLength / oldLength : 0.0;
        p1.setLocation(p0.getX() + (p1.getX() - p0.getX()) * lengthFraction,
         p0.getY() + (p1.getY() - p0.getY()) * lengthFraction);
    }

    public static Line2D generateRandomGradientLine(int width, int height) {
        //so true means lower and false means upper
        final boolean isLower = Math.random() > .5;
        final Point2D start = new Point2D.Float(0, 0);
        if (isLower) {
     //change origin for lower left corner
     start.setLocation(start.getX(), height );
        }
        //radius of our circle
        double radius = Math.sqrt(width * width + height * height);
        //now we want a random theta
        //x = r * cos(theta)
        //y = r * sin(theta)
        double theta = 0.0;
        if (isLower) {
     theta = Math.random() * (Math.PI / 2);
        } else {
     theta = Math.random() * (Math.PI / 2) + (Math.PI / 2);
        }

        float endX = (float)(radius * Math.sin(theta));
        float endY = (float)(radius * Math.cos(theta)) * -1;
        if (isLower) {
     endY = endY + (height );
        }
        final Point2D end = new Point2D.Float(endX, endY);
        extendLine(start, end, radius);

        return new Line2D.Float(start, end);
    }

    public static Point2D getNearestPointOnLine(Point2D end, Line2D line) {
        final Point2D point = line.getP1();
        final Point2D start = line.getP2();
        double a = (end.getX() - point.getX()) * (start.getX() - point.getX()) + (end.getY() - point.getY()) * (start.getY() - point.getY());
        double b = (end.getX() - start.getX()) * (point.getX() - start.getX()) + (end.getY() - start.getY()) * (point.getY() - start.getY());
        final double x = point.getX() + ((start.getX() - point.getX()) * a)/(a+b);
        final double y = point.getY() + ((start.getY() - point.getY()) * a)/(a+b);
        final Point2D result = new Point2D.Double(x, y);
        return result;
    }

    public static double length(double x0, double y0, double x1, double y1) {
        final double dx = x1 - x0;
        final double dy = y1 - y0;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        final Line2D line = generateRandomGradientLine(SIZE, SIZE);
        System.out.println("we're starting with line " + line.getP1() + " " + line.getP2());
        double[][] region = new double[SIZE][SIZE];
        //load up the region with data from our generated line
        for (int x = 0; x < SIZE; x++) {
     for (int y = 0; y < SIZE; y++) {
  final Point2D point = new Point2D.Double(x, y);
  final Point2D nearestPoint = getNearestPointOnLine(point, line);
  if (nearestPoint == null) {
      System.err.println("uh -oh!");
      return;
  }
  final double distance = length(line.getP1().getX(),
            line.getP1().getY(), nearestPoint.getX() ,
            nearestPoint.getY() );

  region[x][y] = distance;        
     }
        }
        //now figure out what our line is from the region
        double runTotal = 0;
        double riseTotal = 0;
        double runCount = 0;
        double riseCount = 0;

        for (int x = 0; x < SIZE; x++) {
     for (int y = 0; y < SIZE; y++) {
  if (x < SIZE - 1) {
      runTotal += region[x + 1][y] - region[x][y];
      runCount++;
  }
  if (y < SIZE - 1) {
      riseTotal += region[x][y + 1] - region[x][y];
      riseCount++;
  }
     }
        }

        double run = 0;
        if (runCount > 0) {
     run = runTotal / runCount;
        }
        double rise = 0;
        if (riseCount > 0) {
     rise = riseTotal / riseCount;
        }

        System.out.println("rise is " + rise + " run is " + run);

        Line2D newLine = getGradientLine(run, rise, SIZE, SIZE , 0, 0);
        System.out.println("ending with line " + newLine.getP1() + " " + newLine.getP2());

        double worst = 0.0;
        int worstX = 0;
        int worstY = 0;
        for (int x = 0; x < SIZE; x++) {
     for (int y = 0; y < SIZE; y++) {
  final Point2D point = new Point2D.Double(x, y);
  final Point2D nearestPoint = getNearestPointOnLine(point, newLine);
  if (nearestPoint == null) {
      System.err.println("uh -oh!");
      return;
  }
  final double distance = length(line.getP1().getX(),
            line.getP1().getY(), nearestPoint.getX() ,
            nearestPoint.getY() );
  final double diff = Math.abs(region[x][y] - distance);
  if (diff > worst) {
      worst = diff;
      worstX = x;
      worstY = y;
  }
     }
        }
        System.out.println("worst is " + worst + " x: " + worstX + " y: " + worstY);
    }
}
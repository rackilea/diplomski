public class PointRef {
      private Point p;
      public PointRef(Point p) { this.p = p; }
      public Point get() { return p; }
      public void invalidate() { p = null; }
  }

  ArrayList<PointRef> list1 = new ArrayList<PointRef>();
  ArrayList<PointRef> list2 = new ArrayList<PointRef>();
  PointRef a = new PointRef(new Point(2, 3));
  list1.add(a); list2.add(a);

  ...

  a.invalidate;
  // Now both lists contain hold a PointRef that points to a null Point.
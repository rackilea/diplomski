public class Sierpinski {
   public static int MAX_LEVEL = 6;
   private int level;
   private Point2D[] points = new Point2D[3];
   private Sierpinski[] childTriangles = null;

   private Sierpinski(int level, Point2D[] points) {
      this.level = level;
      this.points = points;

      if (level < MAX_LEVEL) {
         childTriangles = createChildren();
      }
   }

   public int getLevel() {
      return level;
   }

   public Point2D[] getPoints() {
      return points;
   }

   private Sierpinski[] createChildren() {
      // TODO finish method....
   }

   public void draw(Graphics2D g2) {
      // TODO finish method:
      // ....  draw this triangle

      if (childTriangles != null) {
         for (Sierpinski childTriangle : childTriangles) {
            childTriangle.draw(g2);
         }
      }
   }
}
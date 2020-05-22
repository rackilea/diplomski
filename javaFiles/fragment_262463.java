import java.awt.geom.Area;

...

public static boolean testIntersection(Shape shapeA, Shape shapeB) {
   Area areaA = new Area(shapeA);
   areaA.intersect(new Area(shapeB));
   return !areaA.isEmpty();
}
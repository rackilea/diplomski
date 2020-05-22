public class TestRotate {
    public static void main(String... args) {

        Rectangle r = new Rectangle(50, 50, 100, 100);
        Point check = new Point(100, 151); // clearly outside

        System.out.println("first: " + r.contains(check));

        AffineTransform at = AffineTransform.getRotateInstance(
                Math.PI/4, r.getCenterX(), r.getCenterY());

        Polygon p = new Polygon(); 

        PathIterator i = r.getPathIterator(at);
        while (!i.isDone()) {
            double[] xy = new double[2];
            i.currentSegment(xy);
            p.addPoint((int) xy[0], (int) xy[1]);
            System.out.println(Arrays.toString(xy));

            i.next();
        }

        // should now be inside :)
        System.out.println("second: " + p.contains(check));
    }
}
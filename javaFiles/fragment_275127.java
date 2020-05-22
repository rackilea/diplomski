final int NUM_POINTS = 1000;
final double RADIUS = 100d;

final Point[] points = new Point[NUM_POINTS];

for (int i = 0; i < NUM_POINTS; ++i)
{
    final double angle = Math.toRadians(((double) i / NUM_POINTS) * 360d);

    points[i] = new Point(
        Math.cos(angle) * RADIUS, 
        Math.sin(angle) * RADIUS
    );
}

System.out.println(Arrays.toString(points));
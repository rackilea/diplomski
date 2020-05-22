public class ForkPoints extends RecursiveTask<Set<Point3D>> {

    private static final long serialVersionUID = -5450450150370659468L;

    private final Point3D origin;
    private final double radius;

    static final double SEQUENTIAL_THRESHHOLD = 5;

    public ForkPoints(final Point3D origin, final double radius) {
        this.origin = origin;
        this.radius = radius;
    }

    @Override
    protected Set<Point3D> compute() {
        if (radius <= SEQUENTIAL_THRESHHOLD) {
            return computeValue();
        } else {
            final ForkPoints subCubes[] = new ForkPoints[8];
            final double newRadius = radius / 2;

            Point3D newOrigin = new Point3D();
            newOrigin.setX(origin.getX() + newRadius);
            newOrigin.setY(origin.getY() + newRadius);
            newOrigin.setZ(origin.getZ() + newRadius);
            subCubes[0] = new ForkPoints(newOrigin, newRadius);
            subCubes[0].fork();

            newOrigin = new Point3D();
            newOrigin.setX(origin.getX() + newRadius);
            newOrigin.setY(origin.getY() + newRadius);
            newOrigin.setZ(origin.getZ() - newRadius);
            subCubes[1]   = new ForkPoints(newOrigin, newRadius);
            subCubes[1].fork();

            newOrigin = new Point3D();
            newOrigin.setX(origin.getX() + newRadius);
            newOrigin.setY(origin.getY() - newRadius);
            newOrigin.setZ(origin.getZ() + newRadius);
            subCubes[2]   = new ForkPoints(newOrigin, newRadius);
            subCubes[2].fork();

            newOrigin = new Point3D();
            newOrigin.setX(origin.getX() + newRadius);
            newOrigin.setY(origin.getY() - newRadius);
            newOrigin.setZ(origin.getZ() - newRadius);
            subCubes[3]   = new ForkPoints(newOrigin, newRadius);
            subCubes[3].fork();

            newOrigin = new Point3D();
            newOrigin.setX(origin.getX() - newRadius);
            newOrigin.setY(origin.getY() + newRadius);
            newOrigin.setZ(origin.getZ() + newRadius);
            subCubes[4]   = new ForkPoints(newOrigin, newRadius);
            subCubes[4].fork();

            newOrigin = new Point3D();
            newOrigin.setX(origin.getX() - newRadius);
            newOrigin.setY(origin.getY() + newRadius);
            newOrigin.setZ(origin.getZ() - newRadius);
            subCubes[5]   = new ForkPoints(newOrigin, newRadius);
            subCubes[5].fork();

            newOrigin = new Point3D();
            newOrigin.setX(origin.getX() - newRadius);
            newOrigin.setY(origin.getY() - newRadius);
            newOrigin.setZ(origin.getZ() + newRadius);
            subCubes[6]   = new ForkPoints(newOrigin, newRadius);
            subCubes[6].fork();

            newOrigin = new Point3D();
            newOrigin.setX(origin.getX() - newRadius);
            newOrigin.setY(origin.getY() - newRadius);
            newOrigin.setZ(origin.getZ() - newRadius);
            subCubes[7]   = new ForkPoints(newOrigin, newRadius);
            subCubes[7].fork();

            final Set<Point3D> results = new LinkedHashSet<Point3D>();
            for(final ForkPoints singleSubCube : subCubes) {
                results.addAll(singleSubCube.join());
            }

            return results;
        }
    }

    private Set<Point3D> computeValue() {
        double minX                 =   origin.getX() - radius;
        double maxX                 =   origin.getX() + radius;
        double minY                 =   origin.getY() - radius;
        double maxY                 =   origin.getY() + radius;
        double maxZ                 =   origin.getZ() + radius;
        double x                    =   minX;
        double y                    =   minY;
        double z                    =   origin.getZ() - radius;

        Set<Point3D> points         =   new LinkedHashSet<>();

        boolean notFinished = true;

        while (notFinished) {
            if (x > maxX) {
                x = minX;
                y++;
            }

            if (y > maxY) {
                y = minY;
                z++;
            }

            if (z > maxZ) {
                break;
            }

            Point3D ppoint = new Point3D(); 

            ppoint.setX(x);
            ppoint.setY(y);
            ppoint.setZ(z);

            points.add(ppoint);
            x++;
        }

        return points;
    }
}
/**
 * Quadratic root finder
 * @link http://stackoverflow.com/questions/23956437/quadratic-formula-in-java-for-android-cant-spot-my-mistake
 */
public class QuadraticRootFinder {

    private static final double TOLERANCE = 1.0e-8;

    public static void main(String[] args) {
        if (args.length > 0) {
            double a = Double.parseDouble(args[0]);
            double b = ((args.length > 1) ? Double.parseDouble(args[1]) : 0.0);
            double c = ((args.length > 2) ? Double.parseDouble(args[2]) : 0.0);
            Complex [] roots = QuadraticRootFinder.getRoots(a, b, c);
            for (Complex root : roots) {
                System.out.println(root);
            }
        } else {
            System.out.println("Usage: QuadraticRootFinder <a> <b> <c>");
        }
    }


    public static Complex [] getRoots(double a, double b, double c) {
        Complex [] roots = new Complex[2];
        if (Math.abs(a) <= TOLERANCE) {  // Linear equation; just one root
            if (Math.abs(b) > TOLERANCE) {
                roots = new Complex[1];
                roots[0] = new Complex(-c/b);
            } else {
                throw new IllegalArgumentException(String.format("No roots possible for (a,b,c) = (%f10.3, %f10.3, %f10.3", a, b, c));
            }
        } else {
            double discriminant = b*b-4.0*a*c;
            if (discriminant > 0.0) {  // Two real roots
                roots[0] = new Complex(-b/2.0/a-Math.sqrt(discriminant)/2.0/a, 0.0);
                roots[1] = new Complex(-b/2.0/a+Math.sqrt(discriminant)/2.0/a, 0.0);
            } else { // Two complex conjugate roots
                roots[0] = new Complex(-b/2.0/a, -Math.sqrt(-discriminant)/2.0/a);
                roots[1] = new Complex(-b/2.0/a, +Math.sqrt(-discriminant)/2.0/a);
            }
        }
        return roots;
    }

}

class Complex {
    private final double x;
    private final double y;

    Complex() {
        this(0.0, 0.0);
    }

    Complex(double x) {
        this(x, 0.0);
    }

    Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(").append(x).append(",").append(y).append(")");
        return builder.toString();
    }
}
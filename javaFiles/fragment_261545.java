public class QuarticFunction {

    private static final double NEAR_ZERO = 0.0000001;

    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;

    public QuarticFunction(double a, double b, double c, double d, double e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    public final double[] findRealRoots() {
        if (Math.abs(a) < NEAR_ZERO) {
            return new CubicFunction(b, c, d, e).findRealRoots();
        }

        if (isBiquadratic()) {
            return solveUsingBiquadraticMethod();
        }

        return solveUsingFerrariMethodWikipedia();
    }

    private double[] solveUsingFerrariMethodWikipedia() {
        // http://en.wikipedia.org/wiki/Quartic_function#Ferrari.27s_solution
        QuarticFunction depressedQuartic = toDepressed();
        if (depressedQuartic.isBiquadratic()) {
            double[] depressedRoots = depressedQuartic.solveUsingBiquadraticMethod();
            return reconvertToOriginalRoots(depressedRoots);
        }

        double y = findFerraryY(depressedQuartic);
        double originalRootConversionPart = -b / (4.0 * a);
        double firstPart = Math.sqrt(depressedQuartic.c + 2.0 * y);

        double positiveSecondPart = Math.sqrt(-(3.0 * depressedQuartic.c + 2.0 * y + 2.0 * depressedQuartic.d
                / Math.sqrt(depressedQuartic.c + 2.0 * y)));
        double negativeSecondPart = Math.sqrt(-(3.0 * depressedQuartic.c + 2.0 * y - 2.0 * depressedQuartic.d
                / Math.sqrt(depressedQuartic.c + 2.0 * y)));

        double x1 = originalRootConversionPart + (firstPart + positiveSecondPart) / 2.0;
        double x2 = originalRootConversionPart + (-firstPart + negativeSecondPart) / 2.0;
        double x3 = originalRootConversionPart + (firstPart - positiveSecondPart) / 2.0;
        double x4 = originalRootConversionPart + (-firstPart - negativeSecondPart) / 2.0;

        Set<Double> realRoots = findOnlyRealRoots(x1, x2, x3, x4);
        return toDoubleArray(realRoots);
    }

    private double[] reconvertToOriginalRoots(double[] depressedRoots) {
        double[] originalRoots = new double[depressedRoots.length];
        for (int i = 0; i < depressedRoots.length; ++i) {
            originalRoots[i] = depressedRoots[i] - b / (4.0 * a);
        }
        return originalRoots;
    }

    private double findFerraryY(QuarticFunction depressedQuartic) {
        double a3 = 1.0;
        double a2 = 5.0 / 2.0 * depressedQuartic.c;
        double a1 = 2.0 * Math.pow(depressedQuartic.c, 2.0) - depressedQuartic.e;
        double a0 = Math.pow(depressedQuartic.c, 3.0) / 2.0 - depressedQuartic.c * depressedQuartic.e / 2.0
                - Math.pow(depressedQuartic.d, 2.0) / 8.0;

        CubicFunction cubicFunction = new CubicFunction(a3, a2, a1, a0);
        double[] roots = cubicFunction.findRealRoots();

        for (double y : roots) {
            if (depressedQuartic.c + 2.0 * y != 0.0) {
                return y;
            }
        }
        throw new IllegalStateException("Ferrari method should have at least one y");
    }

    private double[] solveUsingBiquadraticMethod() {
        QuadraticFunction quadraticFunction = new QuadraticFunction(a, c, e);
        if (!quadraticFunction.hasRoots()) {
            return new double[] {};
        }

        double[] quadraticRoots = quadraticFunction.findRoots();
        Set<Double> roots = new HashSet<>();
        for (double quadraticRoot : quadraticRoots) {
            if (quadraticRoot > 0.0) {
                roots.add(Math.sqrt(quadraticRoot));
                roots.add(-Math.sqrt(quadraticRoot));
            } else if (quadraticRoot == 0.00) {
                roots.add(0.00);
            }
        }

        return toDoubleArray(roots);
    }

    public QuarticFunction toDepressed() {
        // http://en.wikipedia.org/wiki/Quartic_function#Converting_to_a_depressed_quartic
        double p = (8.0 * a * c - 3.0 * Math.pow(b, 2.0)) / (8.0 * Math.pow(a, 2.0));
        double q = (Math.pow(b, 3.0) - 4.0 * a * b * c + 8.0 * d * Math.pow(a, 2.0)) / (8.0 * Math.pow(a, 3.0));
        double r = (-3.0 * Math.pow(b, 4.0) + 256.0 * e * Math.pow(a, 3.0) - 64.0 * d * b * Math.pow(a, 2.0) + 16.0 * c
                * a * Math.pow(b, 2.0))
                / (256.0 * Math.pow(a, 4.0));
        return new QuarticFunction(1.0, 0.0, p, q, r);
    }


    private Set<Double> findOnlyRealRoots(double... roots) {
        Set<Double> realRoots = new HashSet<>();
        for (double root : roots) {
            if (Double.isFinite(root)) {
                realRoots.add(root);
            }
        }
        return realRoots;
    }


    private double[] toDoubleArray(Collection<Double> values) {
        double[] doubleArray = new double[values.size()];
        int i = 0;
        for (double value : values) {
            doubleArray[i] = value;
            ++i;
        }
        return doubleArray;
    }
}
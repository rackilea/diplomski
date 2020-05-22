public static double sin(double a) {

    if (a == Double.NEGATIVE_INFINITY || !(a < Double.POSITIVE_INFINITY)) {
        return Double.NaN;
    }

    // If you can't use Math.PI neither,
    // you'll have to create your own PI
    final double PI = 3.14159265358979323846;

    // Fix the domain for a...

    // Sine is a periodic function with period = 2*PI
    a %= 2 * PI;
    // Any negative angle can be brought back
    // to it's equivalent positive angle
    if (a < 0) {
        a = 2 * PI - a;
    }
    // Also sine is an odd function...
    // let's take advantage of it.
    int sign = 1;
    if (a > PI) {
        a -= PI;
        sign = -1;
    }
    // Now a is in range [0, pi].


    // Calculate sin(a)

    // Set precision to fit your needs.
    // Note that 171! > Double.MAX_VALUE, so
    // don't set PRECISION to anything greater
    // than 84 unless you are sure your
    // Factorial.factorial() can handle it
    final int PRECISION = 50;
    double temp = 0;
    for (int i = 0; i <= PRECISION; i++) {
        temp += Math.pow(-1, i) * (Math.pow(a, 2 * i + 1) / Factorial.factorial(2 * i + 1));
    }

    return sign * temp;

}
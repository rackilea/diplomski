// To expand the array
public static double[] expand(double[] array, int newSize) {

    final int length = array.length;

    // let's calculate the new step size
    double step = (length * 1.0) / newSize;

    // fabricated array of x values
    double[] x = new double[length];
    for(int i = 0; i < length; ++i) {
        x[i] = i;
    }

    // using Linear interpolator but it can be any other interpolator
    LinearInterpolator li = new LinearInterpolator(); // or other interpolator
    PolynomialSplineFunction psf = li.interpolate(x, array);

    double[] expandedArray = new double[newSize];
    double xi = x[0];
    for (int i = 0; i < newSize; ++i) {
       expandedArray[i] = psf.value(xi);
       xi += step;
    }
    return expandedArray;
}
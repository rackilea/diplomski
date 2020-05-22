/***
 * Interpolating method
 * @param start start of the interval
 * @param end end of the interval
 * @param count count of output interpolated numbers
 * @return array of interpolated number with specified count
 */
public static double[] interpolate(double start, double end, int count) {
    if (count < 2) {
        throw new IllegalArgumentException("interpolate: illegal count!");
    }
    double[] array = new double[count + 1];
    for (int i = 0; i <= count; ++ i) {
        array[i] = start + i * (end - start) / count;
    }
    return array;
}
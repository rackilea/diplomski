private static final double WHOLE_NUMBER = 1L << 53;
/**
 * Performs a round which is accurate to within 1 ulp. i.e. for values very close to 0.5 it
 * might be rounded up or down. This is a pragmatic choice for performance reasons as it is
 * assumed you are not working on the edge of the precision of double.
 *
 * @param d value to round
 * @return rounded value
 */
public static double round4(double d) {
    final double factor = 1e4;
    return d > WHOLE_NUMBER / factor || d < -WHOLE_NUMBER / factor ? d :
            (long) (d < 0 ? d * factor - 0.5 : d * factor + 0.5) / factor;
}
/**
 * A constant holding the positive infinity of type
 * {@code float}. It is equal to the value returned by
 * {@code Float.intBitsToFloat(0x7f800000)}.
 */
public static final float POSITIVE_INFINITY = 1.0f / 0.0f;

/**
 * A constant holding the negative infinity of type
 * {@code float}. It is equal to the value returned by
 * {@code Float.intBitsToFloat(0xff800000)}.
 */
public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;

/**
 * A constant holding a Not-a-Number (NaN) value of type
 * {@code float}.  It is equivalent to the value returned by
 * {@code Float.intBitsToFloat(0x7fc00000)}.
 */
public static final float NaN = 0.0f / 0.0f;

/**
 * A constant holding the largest positive finite value of type
 * {@code float}, (2-2<sup>-23</sup>)&middot;2<sup>127</sup>.
 * It is equal to the hexadecimal floating-point literal
 * {@code 0x1.fffffeP+127f} and also equal to
 * {@code Float.intBitsToFloat(0x7f7fffff)}.
 */
public static final float MAX_VALUE = 0x1.fffffeP+127f; // 3.4028235e+38f

/**
 * A constant holding the smallest positive normal value of type
 * {@code float}, 2<sup>-126</sup>.  It is equal to the
 * hexadecimal floating-point literal {@code 0x1.0p-126f} and also
 * equal to {@code Float.intBitsToFloat(0x00800000)}.
 *
 * @since 1.6
 */
public static final float MIN_NORMAL = 0x1.0p-126f; // 1.17549435E-38f

/**
 * A constant holding the smallest positive nonzero value of type
 * {@code float}, 2<sup>-149</sup>. It is equal to the
 * hexadecimal floating-point literal {@code 0x0.000002P-126f}
 * and also equal to {@code Float.intBitsToFloat(0x1)}.
 */
public static final float MIN_VALUE = 0x0.000002P-126f; // 1.4e-45f
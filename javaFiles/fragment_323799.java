/**
 * Returns the value obtained by reversing the order of the bytes in the
 * two's complement representation of the specified {@code int} value.
 *
 * @param i the value whose bytes are to be reversed
 * @return the value obtained by reversing the bytes in the specified
 *     {@code int} value.
 * @since 1.5
 */
public static int reverseBytes(int i) {
    return ((i >>> 24)           ) |
           ((i >>   8) &   0xFF00) |
           ((i <<   8) & 0xFF0000) |
           ((i << 24));
}
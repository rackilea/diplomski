/**
 * Fast helper method to convert small doubles to 32-bit int.
 *
 * <p>Note: you should be aware that this uses JavaScript rounding and thus
 * does NOT provide the same semantics as <code>int b = (int) someDouble;</code>.
 * In particular, if x is outside the range [-2^31,2^31), then toInt32(x) would return a value
 * equivalent to x modulo 2^32, whereas (int) x would evaluate to either MIN_INT or MAX_INT.
 */
private static native int toInt32(double val) /*-{
  return val | 0;
}-*/;
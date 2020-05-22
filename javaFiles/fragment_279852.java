/**
 * Since the clipper library uses integer coordinates, we should convert
 * our floating point numbers into fixed point numbers by multiplying by
 * this coefficient. Vary it to adjust the preciseness of the calculations.
 */
public static double floatMultiplier = Math.pow(10, 14);
/**
 * @param value The incoming value to be converted
 * @param low1  Lower bound of the value's current range
 * @param high1 Upper bound of the value's current range
 * @param low2  Lower bound of the value's target range
 * @param high2 Upper bound of the value's target range
 */
public static final double map(double value, double low1, double high1, double low2, double high2) {

    double diff = value - low1;
    double proportion = diff / (high1 - low1);

    return lerp(low2, high2, proportion);
}

// Linearly interpolate between two values
public static final double lerp(double value1, double value2, double amt) {
    return ((value2 - value1) * amt) + value1;
}
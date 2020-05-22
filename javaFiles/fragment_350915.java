/**
 * Normalize x.
 * @param x The value to be normalized.
 * @return The result of the normalization.
 */
public double normalize(double x) {
    return ((x - dataLow) 
            / (dataHigh - dataLow))
            * (normalizedHigh - normalizedLow) + normalizedLow;
}
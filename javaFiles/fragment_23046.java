/**
 * Generate a decimal string representation of a random number within the
 * supplied bounds.
 * 
 * @param random
 *            the random object (if null, a new one will be created)
 * @param lowerBound
 *            the lower bound, inclusive
 * @param upperBound
 *            the upper bound, inclusive
 * @param decimalPlaces
 *            the decimal places of the result
 * @return the formatted string
 */
public static String getRandomValue(final Random random,
    final int lowerBound,
    final int upperBound,
    final int decimalPlaces){

    if(lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0){
        throw new IllegalArgumentException("Put error message here");
    }

    final double dbl =
        ((random == null ? new Random() : random).nextDouble() //
            * (upperBound - lowerBound))
            + lowerBound;
    return String.format("%." + decimalPlaces + "f", dbl);

}
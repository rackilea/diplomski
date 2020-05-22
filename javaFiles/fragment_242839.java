private static final BigInteger TWO = BigInteger.valueOf(2);


/**
 * Computes the integer square root of a number.
 *
 * @param n  The number.
 *
 * @return  The integer square root, i.e. the largest number whose square
 *     doesn't exceed n.
 */
public static BigInteger sqrt(BigInteger n)
{
    if (n.signum() >= 0)
    {
        final int bitLength = n.bitLength();
        BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

        while (!isSqrt(n, root))
        {
            root = root.add(n.divide(root)).divide(TWO);
        }
        return root;
    }
    else
    {
        throw new ArithmeticException("square root of negative number");
    }
}


private static boolean isSqrt(BigInteger n, BigInteger root)
{
    final BigInteger lowerBound = root.pow(2);
    final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
    return lowerBound.compareTo(n) <= 0
        && n.compareTo(upperBound) < 0;
}
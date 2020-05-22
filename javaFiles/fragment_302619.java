import java.math.BigInteger;

public class Fermat {

private BigInteger a, b, N;
private static final BigInteger TWO = BigInteger.valueOf(2);

private static boolean isApproximateSqrt(BigInteger n, BigInteger root) {
    final BigInteger lowerBound = root.pow(2);
    final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
    return lowerBound.compareTo(n) <= 0
        && n.compareTo(upperBound) < 0;
}

private static BigInteger intSqrt(BigInteger n) {
    if (n.signum() >= 0) {
        final int bitLength = n.bitLength();
        BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

        while ( ! isApproximateSqrt(n, root) ) {
            root = root.add(n.divide(root)).divide(TWO);
        }
        return root;
    } else {
        throw new ArithmeticException("square root of negative number");
    }
}

private void init() {
    a = intSqrt(N);                             // a <- ceil(sqrt(N))
    BigInteger b2, root;
    do {
        a = a.add(BigInteger.ONE);              // a <- a + 1
        b2 = (a.multiply(a)).subtract(N);       // b2 <- (a * a) - N
        root = intSqrt(b2);
    } while( root.pow(2).compareTo(b2) != 0 );  // while b2 not exact sqrt
    b = root;
}

public void print() {
    BigInteger a2 = a.pow(2);
    BigInteger b2 = b.pow(2);
    BigInteger squareDifference = a2.subtract(b2);
    System.out.println("A: " + a + "\nB: " + b);
    System.out.println("A^2: " + a2 + "\nB^2: " + b2);
    System.out.println("N: " + N);
    if(squareDifference.compareTo(N) != 0) {
        System.out.println("Something is wrong....");
    }
}

public Fermat(BigInteger aNumber) {
    N = aNumber;
    init();
}

public static void main(String[] args) {
    Fermat f = new Fermat(new BigInteger("90283"));
    f.print();
}
}
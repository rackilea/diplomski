import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {

    public static BigInteger[] generatePAndQ() {
        SecureRandom random = new SecureRandom();

        final int pSizeInBits = 512;
        final int qSizeInBits = 160;
        BigInteger q = BigInteger.probablePrime(qSizeInBits, random);
        BigInteger k = BigInteger.ONE.shiftLeft(pSizeInBits - qSizeInBits); // k = 2**(pSizeInBits - qSizeInBits);

        BigInteger probablyPrime = q.multiply(k).add(BigInteger.ONE); // probablyPrime = q * k + 1
        while (!probablyPrime.isProbablePrime(50)) {
            q = BigInteger.probablePrime(qSizeInBits, random);
            probablyPrime = q.multiply(k).add(BigInteger.ONE);
        }

        BigInteger[] qAndP = new BigInteger[2];
        qAndP[0] = q;
        qAndP[1] = probablyPrime;

        return qAndP;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        final BigInteger[] pAndQ = generatePAndQ();
        double elapsed = (System.nanoTime() - start) / 1e9;
        System.out.printf("q=%d%np=%d%nTime: %f (seconds)%n", pAndQ[0], pAndQ[1], elapsed);
    }
}
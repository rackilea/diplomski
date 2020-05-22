import java.util.*;
import java.math.*;

public class RSA{
    public static void main(String[] args) {
        BigInteger p, q;
        GeneratePrime gp = new GeneratePrime();
        Random random = new Random();
        int bits = 512;
        p = gp.randomPrime(bits, random);
        q = gp.randomPrime(bits, random);
    }
}
import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("200000000000000000000000000000000001");
        BigInteger b2 = new BigInteger("400000000000000000000000000000000000");

        System.out.println(b1.multiply(b2));
        System.out.println(b1.bitCount());
        System.out.println(b1.pow(13));
    }
}
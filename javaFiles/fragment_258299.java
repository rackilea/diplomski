import java.math.BigInteger;

public class BigIntegerTest {

    public BigInteger add(long a, long b){
        BigInteger big1 = new BigInteger(Long.toString(a));
        BigInteger big2 = new BigInteger(Long.toString(b));

        return big1.add(big2);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new BigIntegerTest().add(22342342424323423L, 234234234234234234L));
    }

}
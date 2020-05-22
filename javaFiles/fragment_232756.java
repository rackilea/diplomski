import java.math.BigDecimal;
import java.math.BigInteger;

public class Test {

    public static void main(String[] args) {
        int[] parts = { 2020, 0, 0, 131072 };
        BigInteger integer = BigInteger.valueOf(parts[2] & 0xffffffffL).shiftLeft(32)
            .add(BigInteger.valueOf(parts[1] & 0xffffffffL )).shiftLeft(32)
            .add(BigInteger.valueOf(parts[0] & 0xffffffffL));        
        BigDecimal decimal = new BigDecimal(integer, (parts[3] & 0xff0000) >> 16);
        if (parts[3] < 0) // Bit 31 set
        {
            decimal = decimal.negate();
        }
        System.out.println(decimal);
    }
}
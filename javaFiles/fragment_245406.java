import java.math.BigInteger;
public class BaseConvert {
    static BigInteger fromString(String s, int base, String symbols) {
        BigInteger num = BigInteger.ZERO;
        BigInteger biBase = BigInteger.valueOf(base);
        for (char ch : s.toCharArray()) {
            num = num.multiply(biBase)
                     .add(BigInteger.valueOf(symbols.indexOf(ch)));
        }
        return num;
    }
    static String toString(BigInteger num, int base, String symbols) {
        StringBuilder sb = new StringBuilder();
        BigInteger biBase = BigInteger.valueOf(base);
        while (!num.equals(BigInteger.ZERO)) {
            sb.append(symbols.charAt(num.mod(biBase).intValue()));
            num = num.divide(biBase);
        }
        return sb.reverse().toString();
    }
    static String span(char from, char to) {
        StringBuilder sb = new StringBuilder();
        for (char ch = from; ch <= to; ch++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
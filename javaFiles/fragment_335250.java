import java.math.BigInteger;

public class Long65 {
    private static int base = 65;
    private static String URIchars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_.~";

    public static String toString(Long aNumber) {
        StringBuilder result = new StringBuilder();
        if (aNumber < 0) {
            result.append('-');
            aNumber = -aNumber;
        }
        int r = (int)(aNumber % base);
        if (aNumber - r == 0) 
            result.append(URIchars.charAt(r));
        else 
            result.append(Long65.toString((aNumber - r) / base) + URIchars.charAt(r));
        return result.toString();
    }

    public static long parseLong65(String aNumber) {
        char[] digits;
        int sign = 1;
        if (aNumber.charAt(0) == '-') {
            sign = -1;
            digits = aNumber.substring(1).toCharArray();
        } else {
            digits = aNumber.toCharArray();
        }
        BigInteger bigBase = BigInteger.valueOf(base);
        BigInteger power = bigBase.pow(digits.length);
        BigInteger total = BigInteger.valueOf(0);
        for (char digit : digits){
            power = power.divide(bigBase);
            total = total.add(power.multiply(BigInteger.valueOf(URIchars.indexOf(digit))));
        }
        return sign * total.longValue();
    }
}
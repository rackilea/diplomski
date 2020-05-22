public class RandTest {

    private final static BigDecimal A = new BigDecimal(5).pow(13);
    private final static BigDecimal S = new BigDecimal(314159265);
    private final static BigDecimal minVal = 
         new BigDecimal(2).pow(-46, new MathContext(100));
    private final static BigDecimal maxVal = new BigDecimal(2).pow(46);
    private final static BigDecimal newMax = new BigDecimal(10.0);

    private static BigDecimal r(Integer k) {
        BigDecimal powS = A.pow(k).multiply(S);
        BigDecimal xk = powS.remainder(maxVal);
        BigDecimal result = minVal.multiply(xk);
        System.out.println("k = " + k + ", pows = " + powS + ", xk = " + xk
                + ", result = " + result);
        return result;
    }
}
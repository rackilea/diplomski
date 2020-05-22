public class DestructiveBigInteger extends BigInteger {

    public DestructiveBigInteger(String value) {
        super(value);
    }

    public BigInteger add(BigInteger val) {
        return BigInteger.ONE; // add() method does not behave correctly
    }

    public BigInteger subtract(BigInteger val) {
        throw new UnsupportedOperationException("subtract is broken");
    }
}
public class Base {
    private final String symbols;
    private final BigInteger radix;
    private final Map<Character, Integer> symbolIndex;
    public Base(String symbols) {
        if (symbols.length() <= 1)
            throw new IllegalArgumentException("Must provide at least 2 symbols: length=" + symbols.length());
        this.symbols = symbols;
        this.radix = BigInteger.valueOf(symbols.length());
        this.symbolIndex = new HashMap<>(symbols.length() * 4 / 3 + 1);
        for (int i = 0; i < symbols.length(); i++) {
            Integer prevIndex = this.symbolIndex.putIfAbsent(symbols.charAt(i), i);
            if (prevIndex != null)
                throw new IllegalArgumentException("Duplicate symbol at index " + prevIndex +
                                                   " and " + i + ": " + symbols.charAt(i));
        }
    }
    public BigInteger parse(String text) {
        BigInteger value = BigInteger.ZERO;
        for (int i = 0; i < text.length(); i++) {
            Integer index = this.symbolIndex.get(text.charAt(i));
            if (index == null)
                throw new IllegalArgumentException("Not a valid number: " + text);
            value = value.multiply(this.radix).add(BigInteger.valueOf(index));
        }
        return value;
    }
    public String toString(BigInteger value) {
        if (value.signum() < 0)
            throw new IllegalArgumentException("Negative value not allowed: " + value);
        if (value.signum() == 0)
            return this.symbols.substring(0, 1);
        StringBuilder buf = new StringBuilder();
        for (BigInteger v = value; v.signum() != 0; v = v.divide(this.radix))
            buf.append(this.symbols.charAt(v.mod(this.radix).intValue()));
        return buf.reverse().toString();
    }
    public String convertTo(Base newBase, String text) {
        return newBase.toString(parse(text));
    }
}
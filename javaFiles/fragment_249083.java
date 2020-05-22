class AddAlmostAny<N extends Number>
implements Function<N> {
    @Override
    public N calculate(N n1, N n2) {
        if(n1.getClass() != n2.getClass())
            throw new IllegalArgumentException("unmatched types");

        if(n1 instanceof Integer)
            return (N)new Integer(n1.intValue() + n2.intValue());
        if(n1 instanceof Double)
            return (N)new Double(n1.doubleValue() + n2.doubleValue());
        if(n1 instanceof BigInteger)
            return (N)((BigInteger)n1).add((BigInteger)n2));
        // etc

        throw new IllegalArgumentException("unknown type");
    }
}
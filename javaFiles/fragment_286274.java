public enum Operator {
    add("+", BigDecimal::add),
    subtract("-", BigDecimal::subtract),
    multiply("*", BigDecimal::multiply),
    divide("/", BigDecimal::divide),
    mod("%", BigDecimal::remainder);

    private interface TriFunc {
        BigDecimal apply(BigDecimal a, BigDecimal b, MathContext c);
    }
    private String symbol;
    private TriFunc operation;

    Operator(String symbol, TriFunc operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public BinaryOperator<BigDecimal> getOperation(MathContext c) {
        return (a, b) -> operation.apply(a, b, c);
    }

    // you can also provide a direct method:
    public BigDecimal apply(BigDecimal a, BigDecimal b, MathContext c) {
        return operation.apply(a, b, c);
    }
}
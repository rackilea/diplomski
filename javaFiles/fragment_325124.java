IntFunction<IntUnaryOperator> curriedAdd = new IntFunction<IntUnaryOperator>() {
    @Override
    public IntUnaryOperator apply(final int value) {
        IntUnaryOperator op = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand + value;
            }
        };
        return op;
    }
};
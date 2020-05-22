Function<Integer, Function<Integer, Function<BinaryOperator<Integer>, Integer>>> someComputation2 = new Function<Integer, Function<Integer, Function<BinaryOperator<Integer>, Integer>>>() {
    @Override
    public Function<Integer, Function<BinaryOperator<Integer>, Integer>> apply(Integer i1) {
        Function<Integer, Function<BinaryOperator<Integer>, Integer>> f = new Function<Integer, Function<BinaryOperator<Integer>, Integer>>() {
            @Override
            public Function<BinaryOperator<Integer>, Integer> apply(Integer i2) {
                return new Function<BinaryOperator<Integer>, Integer>() {
                    @Override
                    public Integer apply(BinaryOperator<Integer> integerBinaryOperator) {
                        return integerBinaryOperator.apply(i1, i2);
                    }
                };
            }
        };
        return f;
    }
};
static class Sum extends Operation {

    @Override
    public Integer apply(Integer x) {
        return x + 1;
    }

    public Operation andThen(Operation after) {
        return new Operation() {
            @Override
            public Integer apply(Integer x) {
                return after.apply(Sum.this.apply(x));
            }
        };
    }
}
class AddInteger
implements Function<Integer> {
    @Override
    public Integer calculate(Integer n1, Integer n2) {
        /* actually does
         * return Integer.valueOf(n1.intValue() + n2.intValue()); */
        return n1 + n2;
    }
}
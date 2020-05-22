class IntSubtractor implements Subtractor<Integer> {
    @Override
    Integer subtract(Integer a, Integer b) {
        return Integer.valueOf(a.intValue() - b.intValue());
    }
}
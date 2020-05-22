private static final class Example implements Function<MyBean, String> {
    @Override
    @Nullable
    public String apply(MyBean input) {
        if (null == input) {
            throw new NullPointerException();
        }
        return input.field;
    }
}
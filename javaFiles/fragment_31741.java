private static final class Example implements Function<MyBean, String> {
    @Override
    @Nullable
    public String apply(@Nullable MyBean input) {
        return input == null ? null : input.field;
    }
}
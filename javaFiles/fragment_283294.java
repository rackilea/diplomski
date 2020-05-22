public interface StringTransformer extends UnaryOperator<String>, AutoCloseable {
    static StringTransformer transformer(Function<String,String> f) {
        return f::apply;
    }
    String transform(String s);
    @Override default String apply(String s) { return transform(s); }
    @Override default void close() {}
    default StringTransformer onClose(Runnable r) {
        return new StringTransformer() {
            @Override public String transform(String s) {
                return StringTransformer.this.transform(s);
            }
            @Override public void close() {
                try(StringTransformer.this) { r.run(); }
            }
        };
    }
}
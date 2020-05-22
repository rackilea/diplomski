@FunctionalInterface
interface Converter<A, B> {
    B convert(A a);
    default <C> Converter<C, B> after(Converter<? super C, ? extends A> pre) {
        return c -> this.convert(pre.convert(c));
    }
    default <C> Converter<A, C> then(Converter<? super B, ? extends C> post) {
        return a -> post.convert(this.convert(c));
    }
}
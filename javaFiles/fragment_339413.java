Wrapper<A, B> wrapper = new Wrapper<A, B>(new Function<A, B>() {
    @Override
    public B transform(A a) {
        return new B(a);
    }
});
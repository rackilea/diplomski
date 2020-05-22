private static final Function<Supplier<X>, X> SUPPLY = new Function<....>() {
    public X apply(Supplier<X> in) {
        // If you will never have a null Supplier, you can skip the test;
        // otherwise, null Supplier will be treated same as one that returns null
        // from get(), i.e. skipped
        return (in == null) ? null : in.get();
    }
}
Supplier<T> something = Suppliers.memoize(new Supplier<T>() {
    // heavy computation
    return result.
});

something.get();
something.get(); // second call will return the memoized object.
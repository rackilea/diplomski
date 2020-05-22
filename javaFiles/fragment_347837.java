public Optional<String> f(Optional<A> a, Optional<B> b) {
    if(a.isPresent() && b.isPresent()) {
        return Optional.of(b + "-" + a);
    }
    return  Optional.empty;
}
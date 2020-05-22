<A, B, C extends B, D extends A> List<B> transform(List<D> list, Function<A, Optional<C>> function) {
    List<B> result = new ArrayList<>();
    for (D element : list) {
        Optional<C> optional = function.apply(element);
        if (optional.isPresent()) {
            result.add(optional.get());
        }
    }
    return result;
}
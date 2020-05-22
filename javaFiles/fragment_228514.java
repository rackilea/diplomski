private Stream<T> optionalStream(Optional<T> optional) {
    if (optional.isPresent())
        return Stream.of(optional.get());
    else
        return Stream.empty());
}
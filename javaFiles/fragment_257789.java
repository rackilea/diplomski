static<T> Collector<T,?,Optional<T>> singleOrEmpty() {
    return Collectors.collectingAndThen(
            Collectors.toList(),
            lst -> lst.size() == 1
                    ? Optional.of(lst.get(0))
                    : Optional.empty()
    );
}
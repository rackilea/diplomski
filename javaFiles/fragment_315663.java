final Optional<T> first =
        treeMap.values()
               .stream()
               .skip(index - 1)
               .findFirst();

if (first.isPresent()) {
    final T value = first.get();
}
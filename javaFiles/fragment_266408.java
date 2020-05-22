public Iterable<Record> findAll(final List<Long> id) {
    return ListUtils.partition(id, 10).stream()
        .flatMap(partition -> StreamSupport.stream(
                this.repository.findAll(partition).spliterator(), false))
        .collect(Collectors.toList());
}
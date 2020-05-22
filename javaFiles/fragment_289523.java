final List<MyEntityType> myEntityTypes = Streams.stream(
    Iterables.partition(myEntryIds, 1000))
    .map(myJpaRepository::findAll)
    .map(BeanConverter::convertList)
    .flatMap(List::stream)
    .collect(toImmutableList());
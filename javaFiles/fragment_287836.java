Collection<Foo> uniqueFoos = Stream.concat(listA.stream(), listB.stream())
    .collect(Collectors.toMap(
        Foo::getId,
        f -> f,
        (oldFoo, newFoo) -> oldFoo))
    .values();
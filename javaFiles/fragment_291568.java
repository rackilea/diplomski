......
        .stream()
        .collect(Collectors.collectingAndThen(
            Collectors.groupingBy(
                x -> ImmutableList.of(x.getId()),
                Collectors.mapping(
                    DomainObject::getDomainParam,
                    ImmutableList.toImmutableList())),
            ImmutableMap::copyOf
        ));
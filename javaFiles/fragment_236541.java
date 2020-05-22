public List<Family> transform( final Collection<Child> children ) {
    return children.stream()
            .collect(Collectors.collectingAndThen(
                    Collectors.groupingBy(c -> Arrays.asList(c.getMom(), c.getDad())),
                    map -> map.entrySet().stream()
                            .map(e -> new Family(((Mom) ((List) e.getKey()).get(0)), ((Dad) ((List) e.getKey()).get(1)),
                                    e.getValue().stream().collect(Collectors.toMap(Child::getName, Child::getAge))))
                            .collect(Collectors.toList())));
}
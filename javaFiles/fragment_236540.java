@Getter
@AllArgsConstructor
class GroupingKey {
    Mom mom;
    Dad dad;
}

public List<Family> transformer( final Collection<Child> children ) {
    return children.stream()
            .collect(Collectors.collectingAndThen(
                    Collectors.groupingBy(c -> new GroupingKey(c.getMom(), c.getDad())),
                    map -> map.entrySet().stream()
                            .map(e -> new Family(e.getKey().getMom(), e.getKey().getDad(),
                                    e.getValue().stream().collect(Collectors.toMap(Child::getName, Child::getAge))))
                            .collect(Collectors.toList())));
}